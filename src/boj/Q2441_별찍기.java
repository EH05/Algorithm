package boj;

import java.util.Scanner;

public class Q2441_별찍기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for (int i =0; i<N; i++) {
            for (int j = N-i; j<N; j++) {
                System.out.print(" ");
            }

            for (int k = i; k<N; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
