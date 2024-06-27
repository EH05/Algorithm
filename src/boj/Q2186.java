package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2186 {
    static char[][] chars;
    static String target = null;
    static int[][][] dp;
    static int N, M, K, result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N개의 줄
        M = Integer.parseInt(st.nextToken()); // M개의 알파벳
        K = Integer.parseInt(st.nextToken()); // K개의 칸까지

        chars = new char[N][M];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                chars[r][c] = line.charAt(c);
            }
        }

        target = br.readLine();

        // dp[r][c][idx] 는 (r,c)일때 target의 idx번째 문자부터 끝까지의 경로의 수
        // ex) target이 ABCD일때 dp[0][0][0]은 (0,0)에서 시작해서 target의 첫번째 문자 A를 찾은 경로의 수
        dp = new int[N][M][target.length()];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                Arrays.fill(dp[r][c], -1);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // target의 첫번째 문자와 일치한다면 재귀 돌리기
                if (chars[r][c] == target.charAt(0)) {
                    dfs(r, c, 0, target.length());
                    result += dp[r][c][0];
                }
            }
        }


        System.out.println(result);


    }

    public static void dfs(int r, int c, int idx, int length) {
        // 문자열이 완성되었다면
        if (idx == length - 1) {
            dp[r][c][idx] = 1;
            return;
        }

        // 이미 방문한 곳이면 리턴하고 그값 더함
        if (dp[r][c][idx] != -1) {
            return;
        }

        dp[r][c][idx] = 0;

        for (int i = 1; i <= K; i++) {
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir] * i;
                int nc = c + dc[dir] * i;
                if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1) continue;
                // 다음 문자가 일치하면 또 재귀 돌린다.
                if (chars[nr][nc] == target.charAt(idx + 1)) {
                    dfs(nr, nc, idx + 1, length);
                    // 경로 수 누적
                    dp[r][c][idx] += dp[nr][nc][idx + 1];
                }
            }
        }
    }
}
