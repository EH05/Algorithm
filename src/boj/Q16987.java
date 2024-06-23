package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q16987 {


    static int[][] agg;
    static boolean[] check;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 계란의 수

        agg = new int[2][N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            agg[0][i] = s;
            agg[1][i] = w;
        }

        int result = 0;
        if (N == 1) {
            System.out.println(result);
        } else {
            dfs(0, 1, 0);
        }

    }

    public static void dfs(int start, int target, int cnt) {
        if (start == N - 1) {
        }

        // 내구도는 상대 계란의 무게만큼 깎임. 내구도가 0이되면 계란은 깨짐

        agg[0][start] -= agg[1][target];
        agg[0][target] -= agg[1][start];


    }
}
