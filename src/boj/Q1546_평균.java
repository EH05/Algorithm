package boj;

import java.util.Scanner;

public class Q1546_평균 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N];

        int max = 1;
        float sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
            if (arr[i] >= max) {
                max = arr[i];
            }
        }

        for(int i=0;i<N;i++) {
            sum += ((float) arr[i] /max)*100;
        }
        float average = sum/N;

        System.out.println(average);
    }
}
