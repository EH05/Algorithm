package boj;

import java.util.Scanner;

public class Q2439_별출력 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int line = in.nextInt();


        for(int i=1; i<=line; i++) {
            for(int j=1;j<=line-i;j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
