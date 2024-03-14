package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1271_엄청난부자2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BigInteger N = in. nextBigInteger();
        BigInteger M = in.nextBigInteger();

        System.out.println(N.divide(M));
        System.out.println(N.remainder(M));
    }
}
