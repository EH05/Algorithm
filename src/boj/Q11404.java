package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수


        int[][] map = new int[n + 1][n + 1];

        for (int r = 0; r < n + 1; r++) {
            for (int c = 0; c < n + 1; c++) {
                if(r==c) continue;
                map[r][c] = 987654321;
            }
        }


        for (int bus = 0; bus < m; bus++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

           map[a][b] = Math.min(w, map[a][b]);
        }

//        for (int r = 0; r < n + 1; r++) {
//            for (int c = 0; c < n + 1; c++) {
//                System.out.print(map[r][c] + " ");
//            }
//            System.out.println();
//        }

        for (int temp = 1; temp < n + 1; temp++) {
            for (int start = 1; start < n + 1; start++) {
                for (int end = 1; end < n + 1; end++) {
                    if (map[start][end] > map[start][temp] + map[temp][end]) {
                        map[start][end] = map[start][temp] + map[temp][end];
                    }
                }
            }
        }

        for (int r = 1; r < n + 1; r++) {
            for (int c = 1; c < n + 1; c++) {
                if(map[r][c]>=987654321) {
                    map[r][c]=0;
                }
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }

    }
}
