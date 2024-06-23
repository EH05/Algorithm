package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 전깃줄의 개수

        int[][] wire = new int[N][2]; //[][0]은 A 전봇대, [][1]은 B 전봇대

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        // A 전봇대 기준으로 정렬
        Arrays.sort(wire, (o1, o2) -> o1[0] - o2[0]);


        // i번째 전봇대에 설치 가능한 전깃줄의 개수
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (wire[i][1] > wire[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

//            System.out.println("dp["+i+"]= "+dp[i]);
        }

        // 연결할 수 있는 최대 전깃줄의 개수 (LIS)
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}
