package boj;

import java.util.Scanner;

public class Q2909_캔디구매 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int C = in.nextInt();
        int K = in.nextInt();

        double num = Math.pow(10,K);

        int result = (int) ((int)Math.round(C/num)*num);

        System.out.println(result);

    }
}
