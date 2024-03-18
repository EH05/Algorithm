package boj;

import java.util.Scanner;

public class Q1309 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] dp = new int[N+1];
        dp[0] = 1; // 아예 사자가 없을때
        dp[1] = 3; // N이 1일떄

        for(int i=2; i<=N; i++){
            dp[i] = (2*dp[i-1]+dp[i-2]) % 9901;
        }

        System.out.println(dp[N]);
    }
}
