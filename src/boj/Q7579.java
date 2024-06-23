package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q7579 {
    static class App {
        int memory;
        int cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "App{" +
                    "memory=" + memory +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N개의 앱
        int M = Integer.parseInt(st.nextToken()); // M 바이트의 메모리

        // dp[0][i] = j 는 idx가 i일때 메모리
        // dp[1][i] = j 는 idx가 i일때 비용
        int[][] app = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int memory = Integer.parseInt(st.nextToken());
            app[i][0] = memory;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cost = Integer.parseInt(st.nextToken());
            app[i][1] = cost;
        }

        // M 바이트별 최소 비용을 구하는거면 DP로 저장하면 된다.

        // dp[i]는 비용 i일때의 최대 메모리
        int[] dp = new int[10001]; // 비활성화 비용(최대 100) * 앱의 개수(100)

        for (int i = 0; i < N; i++) {
            for (int j = 10000; j >= app[i][1]; j--) {
                // dp[j]의 메모리는 dp[j] or dp[j-현재 app의 cost]+현재 app의 memory
                dp[j] = Math.max(dp[j],dp[j-app[i][1]]+app[i][0]);
//                System.out.println("dp["+j+"]= "+dp[j]);
            }
        }

        int minCost = 0;
        for(int i=0; i<dp.length; i++){
            // cost가 i일때의 메모리가 M이상이라면
            // 최소 비용은 i이다.
            if(dp[i]>=M){
                minCost = i;
                break;
            }
        }

        System.out.println(minCost);

    }
}
