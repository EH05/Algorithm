package boj;

import java.util.Scanner;

public class Q2010_플러그 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int sum =0;

        for(int i=0; i<N; i++) {
            int multi = in.nextInt();
            sum += multi;
        }

        System.out.println(sum-(N-1));
    }
}
