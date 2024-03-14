package boj;

import java.util.Scanner;

public class Q2145_숫자놀이 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (true) {
            String N = in.next();
            if (N.equals("0")) {
                break;
            }
            while (N.length() > 1) {
                int sum = 0;
                for (int i = 0; i < N.length(); i++) {
                    sum += (N.charAt(i) - '0');
                }
                N = String.valueOf(sum);
            }

            System.out.println(N);
        }
    }
}
