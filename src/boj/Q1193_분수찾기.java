package boj;

import java.util.Scanner;

public class Q1193_분수찾기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int X = in.nextInt();
        int A = 1;
        int B = 1;
        int i = 1;

        while (true) {
            if (X == i || X == 1) break;

            if (A == 1 && B == 1) {
                B++;
                i++;
            }

            if (A == 1 && X != i) {
                while (true) {
                    A++;
                    B--;

                    i++;

                    if (B == 1 || X == i) break;
                }
                if (B == 1 && X != i) {
                    A++;
                    i++;
                }
            } else if (A != 1 && X != i) {
                while (true) {
                    A--;
                    B++;

                    i++;

                    if (A == 1 || X == i) break;
                }
                if (A == 1 && X != i) {
                    B++;
                    i++;
                }
            }
        }
        System.out.println(A + "/" + B);

    }
}
