package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502 {

    static int N, M;
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);

        System.out.println(max);
    }

    public static void makeWall(int cnt) {
        if (cnt == 3) {
            spreadVirus();
            return;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) {
                    map[r][c] = 1;
                    makeWall(cnt + 1);
                    map[r][c] = 0;
                }

            }
        }
    }

    public static void spreadVirus() {
        Queue<Point> que = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 2) {
                    que.add(new Point(r, c));
                }
            }
        }


        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!que.isEmpty()) {
            Point cur = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = cur.x + dr[dir];
                int nc = cur.y + dc[dir];

                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (copyMap[nr][nc] == 0) {
                        que.add(new Point(nr, nc));
                        copyMap[nr][nc] = 2;
                    }
                }
            }
        }

        checkSafeZone(copyMap);

    }


    public static void checkSafeZone(int[][] copyMap){
        int cnt = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(copyMap[r][c] ==0 ){
                    cnt++;
                }
            }
        }

        max = Math.max(cnt, max);
    }

    public static void printMap(int[][] map) {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}
