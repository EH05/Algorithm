package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10819 {
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    static int N, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // N개의 정수

        arr = new int[N];
        temp = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(result);


    }

    public static void dfs(int cnt) {
        if (cnt == N) {
//            System.out.println(Arrays.toString(temp));
            int num = 0;
            for (int i = 0; i < N - 1; i++) {
                num += Math.abs(temp[i] - temp[i + 1]);
            }
            result = Math.max(num, result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp[cnt] = arr[i];
            dfs(cnt+1);
            visited[i] = false;
        }
    }
}
