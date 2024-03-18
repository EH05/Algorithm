package boj;

import java.util.Scanner;

public class Q1947 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        long[] dp = new long[N + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            // 홀수이면
            if (i % 2 != 0) {
                dp[i] = (dp[i - 1]*i - 1)%1000000000;
                // 짝수이면
            } else if (i % 2 == 0) {
                dp[i] = (dp[i - 1]*i + 1)%1000000000;
            }
        }



        System.out.println(dp[N]);
    }
}
