package boj;

import java.util.Scanner;

public class Q2999_비밀이메일 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String message = in.next();

        int num = message.length();

        int R = 0;
        int C = 100;

        for (int i = 1; i < 11; i++) {
            if (i >= C) {
                break;
            }
            if (num % i == 0) {
                R = i;
                C = num / R;
            }
        }

        int cnt = 0;
        char[][] result = new char[R][C];

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                result[j][i] = message.charAt(cnt++);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(result[i][j]);
            }
        }
    }
}

