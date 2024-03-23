package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arrA = new int[N];
        int[] arrB = new int[N];
        boolean[] visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);

        int result = 0;

        for(int i=0; i<N; i++) {
            int max = 0;
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && arrB[j] > max) {
                    max = arrB[j];
                    idx = j;
                }
            }
            visited[idx] = true;
            result += arrA[i]*max;
        }

        System.out.println(result);

    }
}
