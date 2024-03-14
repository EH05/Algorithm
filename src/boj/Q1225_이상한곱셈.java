package boj;

import java.util.Scanner;

public class Q1225_이상한곱셈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String A = in.next();
        String B = in.next();

        long result=0;

        for(int i=0; i<A.length(); i++) {
            for(int j=0; j<B.length(); j++) {
                result += (long) (A.charAt(i) - '0') * (B.charAt(j)-'0');
            }
        }
        System.out.println(result);

    }
}
