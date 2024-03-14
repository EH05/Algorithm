package boj;

import java.util.Scanner;

public class Q11659_누적합 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 배열의 크기
        int M = in.nextInt(); // 테스트 케이스

        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[0] = 0;

            arr[i] = arr[i-1] + in.nextInt();
        }

        for(int tc=0; tc<M; tc++) {
            int start = in.nextInt();
            int end = in.nextInt();
            System.out.println(arr[end] - arr[start-1]);
        }


    }
}
