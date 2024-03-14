package boj;

import java.util.Scanner;

public class Q10768_특별한날 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();

        if (A == 2) {
            if (B > 18) {
                System.out.println("After");
            } else if (B < 18) {
                System.out.println("Before");
            } else if (B == 18) {
                System.out.println("Special");
            }
        } else if (A < 2) {
            System.out.println("Before");
        } else if (A > 2) {
            System.out.println("After");
        }
    }
}