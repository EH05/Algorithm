package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // n개의 줄에 동전의 가치
        int k = Integer.parseInt(st.nextToken()); // 목표

        int[] arr = new int[n+1];
        int[] dp = new int[k+1];

        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for(int i=1; i<n+1; i++){
            int num = arr[i];
            for(int j=num; j<=k; j++){
                dp[j] = dp[j] + dp[j-num];
            }
        }

        System.out.println(dp[k]);
    }
}
