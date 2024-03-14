package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1914_2_하노이탑 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int A = 1;
        int B = 2;
        int C = 3;

        BigInteger result = new BigInteger("2");
        BigInteger one = new BigInteger("1");

        System.out.println(result.pow(N).subtract(one));

        if(N<=20) {
            hanoi(N, A, B, C);
            System.out.println(sb);
        }



    }

    public static void hanoi(int N, int A, int B, int C){
        if (N==1){
            sb.append(A).append(' ').append(C).append('\n');
            return;
        } else {
            hanoi(N-1,A,C,B);
            sb.append(A).append(' ').append(C).append('\n');
            hanoi(N-1,B,A,C);
            return;
        }



    }
}