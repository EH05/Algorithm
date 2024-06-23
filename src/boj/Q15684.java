package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15684 {
    static int[][] ladder;
    static boolean possible = false;
    static int result;
    static int r, c, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 가로선의 개수
        r = Integer.parseInt(st.nextToken());

        ladder = new int[r + 1][c + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // ladder[x][y] 기준으로 오른쪽과 연결됨.
            ladder[x][y] = 1;
            // ladder[x][y+1] 기준으로 왼쪽과 연결됨.
            ladder[x][y + 1] = 2;
        }

        // i번 세로선의 결과가 i번이 나오면 멈춘다.
        for (int i = 0; i < 4; i++) {
            result = i;
            dfs(1, 0);
            if (possible) break;
        }

        if (possible) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }

    private static void dfs(int start, int count) {
        if (possible) return;
        // 추가한 다리의 수가 result와 같다면
        if (result == count) {
            if (check()) possible = true;
            return;
        }

        // 연결해보기
        for (int x = start; x < r + 1; x++) {
            for (int y = 1; y < c; y++) {
                if (ladder[x][y] == 0 && ladder[x][y + 1] == 0) {
                    ladder[x][y] = 1;
                    ladder[x][y + 1] = 2;
                    dfs(x, count + 1);
                    ladder[x][y] = 0;
                    ladder[x][y + 1] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 1; i < c; i++) {
            int x = 1, y = i;
            for (int j = 0; j < r; j++) {
                if (ladder[x][y] == 1) y++;
                else if (ladder[x][y] == 2) y--;
                x++;
            }
            if (y != i) return false;
        }
        return true;
    }
}
