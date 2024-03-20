package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1949 {
    static int[] house;
    static int[][] dp;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        house = new int[N + 1];
        dp = new int[N + 1][2];

        // dp[n][0] : n번 마을이 우수 마을이 아닐 대, n번 마을을 루트노드로하는 하위트리의 마을 주민 수의 총합
        // dp[n][1] : n번 마을이 우수 마을일 때, n번 마을을 루트노드로 하는 하위트리의 마을 주민 수의 총합


        for (int i = 1; i < N + 1; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }


        dfs(1,0);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    public static void dfs(int n, int parent){
            for(int node : list[n]){
                // parent 라면 이미 방문한 곳
                if(node != parent){
                    dfs(node,n);
                    dp[n][0] += Math.max(dp[node][0], dp[node][1]);
                    dp[n][1] += dp[node][0];
                }
            }

            dp[n][1] += house[n];

    }
}
