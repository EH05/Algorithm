package boj;

import java.util.Scanner;

public class Q2530_인공지능시계 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int N = in.nextInt();

        c += N;
        b += c / 60;
        c %= 60;
        a += b / 60;
        b %= 60;
        a %= 24;

        System.out.println(a + " " + b + " " + c);
    }
}
