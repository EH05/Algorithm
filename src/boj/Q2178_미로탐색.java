package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178_미로탐색 {

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

        int N = in.nextInt();
        int M = in.nextInt();

        int[][] maze = new int[N][M]; // 입력받은 미로
        int[][] count = new int[N][M]; // count칸이 -1이면 방문 안한 것 / count칸에 거리 저장

        // count 배열에 -1 저장
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                count[r][c] = -1;
            }
        }

        // maze 입력 받음
        for(int r=0; r<N; r++) {
            String line = in.next();
            for(int c=0; c<M; c++) {
                    maze[r][c] = line.charAt(c)-'0';
            }
        }

        Queue<Point> q = new LinkedList<>(); // 큐 선언

        int[] dr = {-1, 1, 0, 0}; // 상하좌우
        int[] dc = {0, 0, -1, 1};

        q.add(new Point(0,0));
        count[0][0] = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = p.r + dr[dir];
                int nc = p.c + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (count[nr][nc] >=0 || maze[nr][nc] != 1) continue; // 이미 해당 maze칸을 방문하여 count가 0보다 크거나, maze칸이 1이 아니라면 countinue
                count[nr][nc] = count[p.r][p.c]+1; // 처음 방문하는 곳이고 maze 칸이 1이라면 queue에서 빼온 좌표값의 +1
//                System.out.println("count["+nr+"]["+nc+"]="+count[nr][nc]);
                q.add(new Point(nr,nc));

            }
        }

        System.out.println(count[N-1][M-1]+1);

    }
}


