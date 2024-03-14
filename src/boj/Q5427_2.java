package boj;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5427_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();

        for (int tc = 0; tc < T; tc++) {

            Queue<Point> q = new LinkedList<Point>();

            int M = in.nextInt();
            int N = in.nextInt();

            char[][] building = new char[N][M];
            int[][] visit = new int[N][M];

            for (int i = 0; i < N; i++) {
                String line = in.next();
                for (int j = 0; j < M; j++) {
                    building[i][j] = line.charAt(j);
                }
            }

            int i = 0;
            int j = 0;
            int result = -1;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    visit[r][c] = -1;
                    if (building[r][c] == '*') {
                        visit[r][c] = 0;
                        q.add(new Point(r, c));
                    }
                    if (building[r][c] == '@') {
                        visit[r][c] = 0;
                        i = r;
                        j = c;
                    }
                }
            }

            q.add(new Point(i, j));

            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};

            while (!q.isEmpty()) {
                Point p = q.poll();

                if (building[p.x][p.y] != '*' && (p.x == 0 || p.x == N - 1 || p.y == 0 || p.y == M - 1)) {
                    result = visit[p.x][p.y] + 1;
                    break;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int nr = p.x + dr[dir];
                    int nc = p.y + dc[dir];

                    if (nr >= 0 && nc >= 0 && nr < N && nc < M && visit[nr][nc] == -1 && building[nr][nc] != '#') {
                        if ((building[p.x][p.y] != '*' && building[nr][nc] == '*') || building[nr][nc] == '*') {
                            continue;
                        }
                        if (building[p.x][p.y] == '*') {
                            building[nr][nc] = '*';
                        } else {
                            building[nr][nc] = '@';
                        }
                        q.add(new Point(nr, nc));
                        visit[nr][nc] = visit[p.x][p.y] + 1;
                    }
                }


                for(int u=0; i<N;i++) {
                    for(int y=0; j<M; j++) {
                        System.out.print(building[u][y]);
                    }
                    System.out.println();
                }
                System.out.println();


            }
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }

        }
    }
}





