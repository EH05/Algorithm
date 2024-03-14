package boj;

import java.util.Scanner;

public class Q2156_포도주시식 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // 포도주 잔의 개수

        int[] wine = new int[n]; // 입력받은 포도주 잔의 개수 배열
        int[] dp = new int[n]; // n개의 포도주잔의 max값을 저장할 배열

        for (int i = 0; i < n; i++) {
            wine[i] = in.nextInt();
        }


        dp[0] = wine[0];
        if(n>=2) dp[1] = wine[0] + wine[1];
        if(n>=3) dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));

        // dp[i-1]
        // dp[i-2] + wine[i]
        // dp[i-3] +wine[i-1] + wine[i]

        if(n>=4) {
            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
            }
        }

        System.out.println(dp[n - 1]);
    }
}
