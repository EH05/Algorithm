package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q2447 {
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner in  = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = in.nextInt(); // N개의 줄
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = ' ';
            }
        }

        printSquare(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void printSquare(int r, int c, int length) {
        if(length == 1){
            arr[r][c] = '*';
            return;
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                printSquare(r + i * (length/3), c + j * (length/3), length/3);
            }
        }
    }
}

