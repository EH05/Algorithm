package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Q15686 {

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집

        int[][] city = new int[N][N];
        List<Point> house = new ArrayList<>();
        List<Point> chicken = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int num = Integer.parseInt(st.nextToken());

                city[r][c] = num;
                if (num == 1) {
                    house.add(new Point(r, c));
                } else if (num == 2) {
                    chicken.add(new Point(r, c));
                }
            }
        }

        result = Integer.MAX_VALUE;

        // open[i] = true 는 i번째 치킨집이 선택되었다(폐업하지않았다.)
        boolean[] open = new boolean[chicken.size()];

        DFS(M, house, chicken, open, 0, 0);

        System.out.println(result);
    }

    public static void DFS(int M, List<Point> house, List<Point> chicken, boolean[] open, int start, int cnt) {
        // M개의 치킨집이 선택되면
        // 현재까지 선택된 치킨집들에 대한 치킨거리 계산
        if (cnt == M) {
            int minLen = 0; // 최소 치킨 거리

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {

                        // 집 i와 치킨집 j 사이의 거리
                        int dist = Math.abs(house.get(i).r - chicken.get(j).r) + Math.abs(house.get(i).c - chicken.get(j).c);

                        // 집 i와 가장 가까운 치킨집의 거리 구하기
                        temp = Math.min(temp, dist);
                    }
                }
                minLen += temp;
            }
            result = Math.min(minLen, result);
            return;
        }

        // 아직 선택할 치킨집이 남아있다면 조합!!
        for (int i = start; i < chicken.size(); i++) {
            // i번째 치킨집 선택
            open[i] = true;
            DFS(M, house, chicken, open, i + 1, cnt + 1);
            // i번째 치킨집 폐업
            open[i] = false;
        }
    }
}
