package boj;

import java.util.Scanner;

public class re_Q15552_시간초과 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T= in.nextInt();

        for(int i=1; i<=T; i++) {
            int A=in.nextInt();
            int B=in.nextInt();
            System.out.println(A+B);
        }
    }
}
