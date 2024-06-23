package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 설탕 무게


        int[] dp = new int[N + 1];

        Arrays.fill(dp, -1);


        dp[3] = 1;
        if (N > 4) {
            dp[5] = 1;
        }
        for (int i = 6; i < N + 1; i++) {
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;
            } else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
            } else {
                if(dp[i-3] != -1 && dp[i-5] != -1){
                    dp[i] = Math.min(dp[i-3], dp[i-5])+1;
                }
            }
        }

        System.out.println(dp[N]);
    }
}
