package boj;

import java.util.Scanner;

public class Q1009_분산처리 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            int num = a % 10;

            if (num == 1 || num == 5 || num == 6) {
                System.out.println(num);
            } else if (num == 4 || num == 9) {
                if (b % 2 == 0) {
                    System.out.println((int) (Math.pow(a, 2)) % 10);
                } else System.out.println((int) (Math.pow(a, b % 2)) % 10);
            } else if (num == 2 || num == 3 || num == 7 || num == 8) {
                if (b % 4 == 0) {
                    System.out.println((int) (Math.pow(a, 4)) % 10);
                } else System.out.println((int) (Math.pow(a, b % 4)) % 10);
            } else if (num == 0) {
                System.out.println("10");
            }
        }
    }
}

