package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q1676_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger result = new BigInteger("1");
        while (n >= 1) {
            result = result.multiply(BigInteger.valueOf(n));
            n--;
        }

        int count = 0;


        while(result.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            count++;
            result = result.divide(BigInteger.TEN);
        }

        System.out.println(count);


    }
}
