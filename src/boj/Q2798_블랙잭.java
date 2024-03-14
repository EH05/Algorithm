package boj;

import java.util.Scanner;

public class Q2798_블랙잭 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] arr = new int[N];

        int sum = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        max = arr[0] + arr[1] + arr[2];
        if (max >= M) {
            max = sum;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int z = j + 1; z < N; z++) {
                    sum = arr[i] + arr[j] + arr[z];
                    if (sum <= M && sum >= max) {
                        max = sum;
                    }
                }

            }
        }
        System.out.println(max);
    }
}