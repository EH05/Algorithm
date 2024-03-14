package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1780 {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findcount(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);


    }

    public static void findcount(int row, int col, int size) {

        int first = arr[row][col];
        boolean isSame = true;

        start:
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != first) {
                    isSame = false;
                    break start;
                }
            }
        }


        if (isSame) {
            switch (first) {
                case -1:
                    minus++;
                    break;
                case 0:
                    zero++;
                    break;
                case 1:
                    plus++;
                    break;
            }
        } else {
            int newsize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    findcount(row + i * newsize, col + j * newsize, newsize);
                }
            }
        }
    }
}
