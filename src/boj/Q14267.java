package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14267 {

    static int[] dp;
    static int[] boss;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 직원수
        int m = Integer.parseInt(st.nextToken()); // 칭찬의 수

        // dp[i] = j 는 i번째 사람이 받는 칭찬의 정도
        dp = new int[n+1];
        boss = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++){
            boss[i] = Integer.parseInt(st.nextToken());
            if(boss[i]==-1) boss[i] = 0;
        }

        for(int k=0; k<m; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dp[i] += w;
        }

        for(int i=1; i<n+1; i++){
            dp[i] = dp[i]+dp[boss[i]];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n+1; i++){
            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb);

    }
}
