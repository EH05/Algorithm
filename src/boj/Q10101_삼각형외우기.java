package boj;

import java.util.Scanner;

public class Q10101_삼각형외우기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();

        int sum = A + B + C;

        if (sum == 180) {
            if (A == B && B == C) {
                System.out.println("Equilateral");
            } else if (A == B || A == C || B == C) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }

        if(sum != 180) {
            System.out.println("Error");
        }
    }
}

