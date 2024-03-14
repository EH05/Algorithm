package boj;

import java.util.Scanner;

public class Q2480_3개의값을비교 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // A,B,C 입력
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();

        // if (모두 다른눈)
        if (A != B && B != C && A !=C ) {
            if (A > B && A > C) {
                System.out.println(A * 100);
            } else if (B > A && B > C) {
                System.out.println(B * 100);
            } else {
                System.out.println(C * 100);
            }
        }
        // if (모두 같은눈)
        else if (A == B && B == C) {
            System.out.println(10000 + (A * 1000));
        }
        //if (2개만 같은 눈)
        else if (A == B) {
            System.out.println(1000 + (A * 100));
        }
        else if (A == C) {
            System.out.println(1000 + (A * 100));
        }
        else {
            System.out.println(1000 + (B * 100));
        }

    }
}
