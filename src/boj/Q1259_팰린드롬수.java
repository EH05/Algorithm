package boj;

import java.util.Scanner;

public class Q1259_팰린드롬수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (true) {
            String A = in.next();

            if (A.equals("0")) {
                break;
            }

            boolean yes = true;

            for (int i = 0; i < A.length(); i++) {


                char first = A.charAt(i);
                char last = A.charAt(A.length() - (i + 1));

                if (first != last) {
                    yes = false;
                    break;
                }
            }

            if (yes) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
