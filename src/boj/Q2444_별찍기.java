package boj;

import java.util.Scanner;

public class Q2444_별찍기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int N = in.nextInt();

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N - k; i++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= k * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int k = N-1; k >= 1; k--) {
            for (int i = 1; i <= N - k; i++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= k * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}