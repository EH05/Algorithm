package boj;

import java.util.Scanner;

public class Q1075_나누기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int F = in.nextInt();

        N -= (N%100);

        while(true) {
            if(N%F == 0) {
                break;
            }
            N++;
        }
        System.out.format("%02d", (N%100));
    }
}
