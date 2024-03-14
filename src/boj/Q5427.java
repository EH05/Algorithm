package boj;

import java.util.Scanner;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Q5427 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int tc = 0; tc < T; tc++) {

            Queue<Point> q = new LinkedList<Point>();
            Queue<Point> w = new LinkedList<Point>();

            int M = in.nextInt();
            int N = in.nextInt();
            int fire = 0;
            int cnt;

            char[][] building = new char[N][M];
            int[][] distance = new int[N][M];

            for (int i = 0; i < N; i++) {
                String line = in.next();
                for (int j = 0; j < M; j++) {
                    building[i][j] = line.charAt(j);
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (building[r][c] == '@') {
                        q.add(new Point(r, c));
                    }
                    if (building[r][c] == '*') {
                        w.add(new Point(r, c));
                        fire++;
                    }
                }
            }

            all: while(true) {

                // 불이 있는 경우
                spread:
                while (fire != 0) {
                    System.out.println("여기 들어옴");

                    cnt = fire;
                    fire = 0;

                    while (cnt != 0) {
                        cnt--;

                        int[] dr = {1, -1, 0, 0};
                        int[] dc = {0, 0, -1, 1};

                        Point p = q.poll(); // 상근이 위치 큐

                        int stop = 0;

                        for (int dir = 0; dir < 4; dir++) {
                            int nr = p.x + dr[dir];
                            int nc = p.y + dc[dir];


                            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                                System.out.println("여기도 들어옴");
                                System.out.println(distance[p.x][p.y] + 1);
                                break all;
                            }

                            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
//                                if (building[nr][nc] == '*' || building[nr][nc] == '#') {
//                                    stop++;
//                                    if (stop == 4) {
//                                        System.out.println("IMPOSSIBLE");
//                                        break all;
//                                    }
//                                }
                                if (building[nr][nc] == '.') {
                                    building[nr][nc] = '@';
                                    distance[nr][nc] = distance[p.x][p.y] + 1;
                                    q.add(new Point(nr, nc));
                                    System.out.println("nr,nc= "+nr+","+nc+"넣음");
                                }
                            }
                        }


                        Point h = w.poll(); // 불 위치 큐

                        for (int dir = 0; dir < 4; dir++) {
                            int nr = h.x + dr[dir];
                            int nc = h.y + dc[dir];

                            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                                if (building[nr][nc] == '.') {
                                    building[nr][nc] = '*';
                                    w.add(new Point(nr, nc));
                                    fire++;
                                }
                                if(building[nr][nc] == '#' || building[nr][nc] == '*'){
                                    cnt++;
                                }

                            }
                        }


                    }
                }

                // 불이 없는 경우
                nothing:
                while (fire == 0) {

                    int[] dr = {1, -1, 0, 0};
                    int[] dc = {0, 0, -1, 1};

                    Point p = q.poll();

                    int stop = 0;

                    for (int dir = 0; dir < 4; dir++) {
                        int nr = p.x + dr[dir];
                        int nc = p.y + dc[dir];

                        if (nr < 0 || nc < 0 || nr > N || nc > M) {
                            System.out.println(distance[p.x][p.y] + 1);
                            break all;
                        }

                        if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            if (building[nr][nc] == '#') {
                                stop++;
                                if (stop == 4) {
                                    System.out.println("IMPOSSIBLE");
                                    break all;
                                }
                            }
                            if (building[nr][nc] == '.') {
                                building[nr][nc] = '@';
                                distance[nr][nc] = distance[p.x][p.y] + 1;
                                q.add(new Point(nr, nc));
                            }
                        }
                    }
                }
            }




        }
    }
}