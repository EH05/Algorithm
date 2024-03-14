package boj;

import java.util.Scanner;

public class Q1085_직사각형에서탈출 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();
        int w = in.nextInt();
        int h = in.nextInt();

        int a_min = (w - x) < x ? (w - x) : x;
        int b_min = (h - y) < y ? (h - y) : y;

        if(a_min <b_min) {
            System.out.println(a_min);
        }
        else System.out.println(b_min);
    }
}
