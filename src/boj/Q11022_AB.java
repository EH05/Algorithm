package boj;

import java.util.Scanner;

public class Q11022_AB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for(int i=1;i<=T; i++) {
            int A=in.nextInt();
            int B=in.nextInt();
            int sum=A+B;
            System.out.printf("Case #%d: %d + %d = "+sum, i,A,B);
            System.out.println();
        }
    }
}
