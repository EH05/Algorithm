package boj;

import java.awt.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q2667 {
    public static void main(String[] args) {
        Queue<Point> que = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = in.nextInt();
        int totalCnt = 0;
        int count = 0;

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = in.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }


        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        search:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    que.add(new Point(i, j));
                    count = 1;
                    map[i][j]=0;

                    while (!que.isEmpty()) {
                        Point p = que.poll();

                        for (int div = 0; div < 4; div++) {
                            int nr = p.x + dr[div];
                            int nc = p.y + dc[div];


                            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                            if (map[nr][nc] == 1) {
                                que.add(new Point(nr, nc));
                                count++;
                                map[nr][nc] = 0;
                            }
                        }

                    }
                    totalCnt++;
                    pq.add(count);

                }
            }
        }

        System.out.println(totalCnt);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }


    }
}
