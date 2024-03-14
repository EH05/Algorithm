package boj;

import java.util.Scanner;

public class Q2775_부녀회장이될테야 {
    public static void main(String[] args) {
        // 0층 1 2 3 4 5 6 7
        // 1층 1 3 6 10 15 21 28
        // 2층 1 4 10 20 35 56 84
        // 3층 1 5 15 35 70 126 210

        Scanner in = new Scanner(System.in);

        int tCase = in.nextInt();


        int[][] arr = new int[15][15];

        for (int i = 0; i < 15; i++) {
            arr[0][i] = i;
            arr[i][1] = 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }

        for (int z = 0; z < tCase; z++) {
            int k = in.nextInt();
            int n = in.nextInt();
            System.out.println(arr[k][n]);
        }
    }
}
