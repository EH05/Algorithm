package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14500 {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N][M];
        visited = new boolean[N][M];


        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                visited[r][c] = true;
                getMax(r, c, map[r][c], 1);
                visited[r][c] = false;
            }
        }

        System.out.println(result);
    }


    public static void getMax(int r, int c, int sum, int cnt) {

        if (cnt == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;

            // ㅜ 모양때문에.,,,,
            if(cnt==2){
                visited[nr][nc] = true;
                // 해당 r,c에서 다시 탐색 시작
                getMax(r,c,sum+map[nr][nc], cnt+1);
                visited[nr][nc] = false;
            }
            visited[nr][nc] = true;
            getMax(nr,nc,sum+map[nr][nc], cnt+1);
            visited[nr][nc] = false;
        }
    }


}

