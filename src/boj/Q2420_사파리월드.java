package boj;

import java.util.Scanner;

public class Q2420_사파리월드 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long N = in.nextInt();
        long M = in.nextInt();

        long mul=0;

        if(N-M>=0) {
            mul = N-M;
        } else if (N-M<0) {
            mul = -(N-M);
        }

        System.out.println(mul);
    }
}
