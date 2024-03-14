package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1247_부호 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int j = 0; j < 3; j++) {
            int N = in.nextInt();
            BigInteger result = BigInteger.ZERO;

            for (int i = 0; i < N; i++) {
                BigInteger num = in.nextBigInteger();

                result = result.add(num);
            }

            if (result.compareTo(BigInteger.ZERO) < 0) {
                System.out.println('-');
            } else if (result.compareTo(BigInteger.ZERO) > 0) {
                System.out.println('+');
            } else System.out.println('0');
        }
    }
}
