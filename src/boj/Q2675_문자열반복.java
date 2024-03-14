package boj;

import java.util.Scanner;

public class Q2675_문자열반복 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int R = in.nextInt();
            String S = in.next();

            for (int j = 0; j < S.length(); j++) {
                for (int f = 0; f < R; f++) {
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();

        }
    }
}
