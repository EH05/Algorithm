package boj;

import java.util.Scanner;

public class Q5596_시험점수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int S = 0;
        int T = 0;

        for(int i=0; i<4; i++) {
            S+=in.nextInt();
        }

        for(int i=0; i<4; i++) {
            T+=in.nextInt();
        }

        if(S==T) {
            System.out.println(S);
        } else {
            System.out.println(Math.max(S, T));
        }
    }
}
