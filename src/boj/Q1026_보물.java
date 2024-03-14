package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1026_보물 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // N개의 수

        int[] A = new int[N]; // 배열 A
        int[] B = new int[N]; // 배열 B

        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = in.nextInt();
        }

        Arrays.sort(A);

        int tmp=Integer.MAX_VALUE;
        int answer=0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            int max = 0;

            // B[j]에서의 최댓값 구하기
            for (int j = 0; j < N; j++) {
                if (B[j] == max) {
                    count++;
                    continue;
                }
                if (B[j] < tmp && B[j] > max) {
                    max = Math.max(max, B[j]);
                    count = 1;
                }
            }

            tmp = max;
            if (count == 1) {
                answer += A[i] * tmp;
            }
            else {
                while (count != 0) {
                    answer += A[i] * tmp;
                    i++;
                    count--;

                }
                i--;
            }
        }

        System.out.println(answer);

    }
}
