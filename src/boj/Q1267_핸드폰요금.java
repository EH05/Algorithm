package boj;

import java.util.Scanner;

public class Q1267_핸드폰요금 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int Y_result = 0;
        int M_result = 0;

        for (int i = 0; i < N; i++) {
            int sec = in.nextInt();

            int Y = (sec / 30) * 10;
            if (sec % 30 >= 0) {
                Y += 10;
            }
            Y_result += Y;

            int M = (sec / 60) * 15;
            if (sec % 60 >= 0) {
                M += 15;
            }
            M_result += M;
        }

        if (Y_result > M_result) {
            System.out.println("M" + " " + M_result);
        } else if (Y_result < M_result) {
            System.out.println("Y" + " " + Y_result);
        } else System.out.println("Y" + " " + "M" + " " + M_result);

    }
}
