package boj;

import java.util.Scanner;

public class Q15649 {
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // N까지
        int M = in.nextInt(); // 길이가 M인 수열

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        permutation(0, M);
    }

    public static void permutation(int idx, int m) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            result[idx] = arr[i];
            visited[i] = true;
            permutation(idx + 1, m);
            visited[i] = false;
        }
    }
}
