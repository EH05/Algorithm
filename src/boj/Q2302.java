package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 좌석의 개수
        int M = Integer.parseInt(br.readLine()); // 고정석의 개수

        int[] vip = new int[M];

        for(int i=0; i<M; i++){
            vip[i] = Integer.parseInt(br.readLine());
        }

        // 최악의 경우 완탐 시, O(2^40) => DP

        // dp[i]=j 는 이동가능한 i명이 이동할 수 있는 경우의 수 j
        int[] dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<N+1; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        int idx = 0;
        int result = 1;

        // VIP 좌석 사이에 이동가능한 사람들 숫자 찾아서
        // 그 사람들이 이동할 수 있는 경우의수 (dp[people]) 를 결과에 곱하기
        for(int i=0; i<M; i++){
            int people = vip[i]-idx-1;
            result*=dp[people];
            idx = vip[i];
        }

        result*=dp[N-idx];

        System.out.println(result);
    }
}
