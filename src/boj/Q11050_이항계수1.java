package boj;

import java.util.Scanner;

public class Q11050_이항계수1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        System.out.println(result(N,K));

    }

    public static int result(int n, int k){

        if(n==k || k==0) {
            return 1;
        }

        return result(n-1, k-1) + result(n-1,k);
    }
}
