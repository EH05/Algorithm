package boj;

import java.util.Scanner;

public class Q2754_학점계산 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String score = in.next();

        if (score.charAt(0) == 'A') {
            if (score.charAt(1) == '+') {
                System.out.println(4.3);
            } else if (score.charAt(1) == '0') {
                System.out.println(4.0);
            } else System.out.println(3.7);
        }

        if (score.charAt(0) == 'B') {
            if (score.charAt(1) == '+') {
                System.out.println(3.3);
            } else if (score.charAt(1) == '0') {
                System.out.println(3.0);
            } else System.out.println(2.7);
        }

        if (score.charAt(0) == 'C') {
            if (score.charAt(1) == '+') {
                System.out.println(2.3);
            } else if (score.charAt(1) == '0') {
                System.out.println(2.0);
            } else System.out.println(1.7);
        }

        if (score.charAt(0) == 'D') {
            if (score.charAt(1) == '+') {
                System.out.println(1.3);
            } else if (score.charAt(1) == '0') {
                System.out.println(1.0);
            } else System.out.println(0.7);
        }


        if (score.charAt(0) == 'F') {
            System.out.println(0.0);
        }
    }
}
