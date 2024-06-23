package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3109 {
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dir = {-1, 0, 1};
    static int count = 0;
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];


        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
            }
        }

        for (int i = 0; i < R; i++) {
            found = false;
            dfs(i, 0);
        }
        System.out.println(count);


    }

    static void dfs(int r, int c) {
        if (c == C - 1) {
            count++;
            found = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nr = r + dir[i];
            int nc = c + 1;

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (map[nr][nc] == '.' && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc);
                if (found) return;
            }
        }
    }
}
