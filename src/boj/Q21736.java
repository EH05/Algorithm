package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q21736 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Point> que = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        Character[][] map = new Character[N][M];
        boolean[][] visited = new boolean[N][M];
        int count = 0; // 만나는 사람의 수

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c);
                if (line.charAt(c) == 'I') {
                    que.add(new Point(r, c));
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!que.isEmpty()) {
            Point curr = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = curr.x + dr[dir];
                int nc = curr.y + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (!visited[nr][nc] && map[nr][nc] == 'X') {
                    visited[nr][nc] = true;
                    continue;
                }

                if (!visited[nr][nc] && map[nr][nc] == 'P') {
                    visited[nr][nc] = true;
                    count++;
                    que.add(new Point(nr, nc));
                } else if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    que.add(new Point(nr, nc));
                }
            }

        }

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }


    }
}
