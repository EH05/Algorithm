package boj;

import java.util.Scanner;

public class Q10250_ACM호텔 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int H = in.nextInt();
            int W = in.nextInt();
            int N = in.nextInt();

            int[][] arr = new int[H][W];

            int h = N % H;
            int w = N / H + 1;
            if (h == 0) {
                h = H;
                w = N / H;
            }

            System.out.println(h * 100 + w);

        }
    }
}
