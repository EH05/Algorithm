package boj;

import java.util.Scanner;

public class Q1074_Z {

    static int N;
    static int R;
    static int C;
    static int answer;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();

        R = in.nextInt();

        C = in.nextInt();

        findAnswer(N, R, C);

        System.out.println(answer); // git test


    }


    public static void findAnswer(int n, int r, int c) {
        if (n == 0) return;
        int temp = (int) Math.pow(2, n - 1);
        if (r < temp) {
            if (c < temp) {
                findAnswer(n - 1, r, c);
            } else {
                answer += temp * temp;
                findAnswer(n - 1, r, c - temp);
            }
        } else {
            if (c < temp) {
                answer += 2 * (temp * temp);
                findAnswer(n - 1, r - temp, c);
            } else {
                answer += 3 * (temp * temp);
                findAnswer(n - 1, r - temp, c - temp);
            }
        }

    }
}
