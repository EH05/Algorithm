package boj;

import java.util.Scanner;

public class Q10810_공넣기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int[] basket = new int[N];

        for (int m = 0; m < M; m++) {
            int i = in.nextInt();
            int j = in.nextInt();
            int k = in.nextInt();

            basket[i-1] = k;


            for (; j > i; j--) {
                basket[j-1] = k;
            }

        }
        for (int p = 0; p < N; p++) {
            System.out.println(basket[p]);
        }
    }
}



