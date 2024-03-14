package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2578_빙고 {

    static int count = 10;
    static int line = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int[][] map = new int[5][5];

        for (int r = 0; r < 5; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < 2; i++) {
            for (int r = 0; r < 5; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 5; c++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (map[r][c] == num) {
                        map[r][c] = 0;
                    }
                }
            }
        }

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }

        all:
        while (true) {
            for (int r = 0; r < 5; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 5; c++) {
                    int num = Integer.parseInt(st.nextToken());
                    count++;
                    if (map[r][c] == num) {
                        map[r][c] = 0;
                        getcount(map);
                        if(line==3) break all;
                    }
                }
            }
        }

        System.out.println(count);


    }


    public static void getcount(int[][] map) {


        // 행 검사
        for (int r = 0; r < 5; r++) {
            int sum = 0;
            for (int c = 0; c < 5; c++) {
                sum += map[r][c];
            }
            if (sum == 0) line++;
        }

        // 열 검사
        for (int c = 0; c < 5; c++) {
            int sum = 0;
            for (int r = 0; r < 5; r++) {
                sum += map[r][c];
            }
            if (sum == 0) line++;
        }

        int sum = 0;
        // 대각선 검사
        for (int r = 0; r < 5; r++) {
            sum += map[r][r];
        }
        if (sum == 0) line++;


        sum = 0;
        // 대각선 검사
        for (int r = 0; r < 5; r++) {
            sum += map[r][4 - r];
        }
        if (sum == 0) line++;


    }
}
