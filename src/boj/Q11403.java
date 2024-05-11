package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 정점의 개수
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int temp = 0; temp < N; temp++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    // 갈 수 있는 경로가 있다면
                    if (map[start][temp] == 1 && map[temp][end] == 1) {
                        map[start][end] = 1;
                    }
                }
            }
        }


        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }

    }

}
