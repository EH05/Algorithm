package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] bag = new int[N + 1][2];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken()); // 무게
            bag[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }


        // 무게별 담을 수 있는 물건들의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                // 해당 물건 담을 수 없는 경우
                if (bag[i][0] > j) {
                    dp[i][j] = dp[i - 1][j]; // 이전 물건까지의 값 그대로 가져감
                    // 해당 물건 담을 수 있는 경우
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bag[i][0]] + bag[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
