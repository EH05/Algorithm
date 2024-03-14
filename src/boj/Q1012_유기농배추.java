package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1012_유기농배추 {

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt(); // 테스트케이스의 수

        for (int tc = 0; tc < T; tc++) {
            // 테스트 케이스 시작

            Queue<Point> turn = new LinkedList<>(); // 큐 선언

            int M = in.nextInt(); // 배추밭의 가로길이
            int N = in.nextInt(); // 배추밭의 세로길이
            int K = in.nextInt(); // 배추가 심어져있는 위치의 개수

            int[][] ground = new int[N][M]; // 배추밭 배열 생성
            boolean[][] visit = new boolean[N][M]; // 방문했는지 확인

            // 배추밭에 배추가 심어져있는 곳을 1로 바꿈
            for (int i = 0; i < K; i++) {
                int c = in.nextInt();
                int r = in.nextInt();

                ground[r][c] = 1;
            }

            int[] dr = {-1, 1, 0, 0}; // 상하좌우
            int[] dc = {0, 0, -1, 1};

            int worm = 0; // 지렁이의 갯수

//            System.out.println();
//            for (int r = 0; r < N; r++) {
//                for (int c = 0; c < M; c++) {
//                    System.out.print(ground[r][c]);
//                }
//                System.out.println();
//            }



            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    // 특정 좌표의 값이 1이거나 방문한적없는지 확인
                    if (ground[r][c] == 1 && !visit[r][c]) {
                        turn.add(new Point(r,c)); // 특정 좌표가 1이거나 방문한적이 없으면 queue에 넣는다.
                        visit[r][c] = true;
                        worm++;  // 지렁이의 수가 증가
//                        System.out.println();
//                        System.out.println("r="+r+", c="+c+"일때, worm="+worm);

                        // queue가 빌때까지 while문 진행
                        while (!turn.isEmpty()) {
                            Point p = turn.poll();  // 제일 front에 있는 value 반환

                            // 해당 value의 상하좌우 탐색
                            for (int dir = 0; dir < 4; dir++) {
                                int nr = p.r + dr[dir];
                                int nc = p.c + dc[dir];

                                // nr,nc가 범위에 벗어나면 넘어가기
                                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                                // 상하좌우중 1인게 있으면 그 좌표를 queue에 넣고, bool값 true로 변환
                                if (ground[nr][nc] == 1 && !visit[nr][nc]) {
                                    turn.add(new Point(nr,nc));
                                    visit[nr][nc] = true;
//                                    System.out.println(nr+","+nc+"이 true로 변환");
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(worm);

        }
    }
}
