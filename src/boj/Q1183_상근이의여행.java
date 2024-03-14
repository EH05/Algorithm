package boj;

import java.util.Scanner;

public class Q1183_상근이의여행 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int N = in.nextInt(); // 국가의 수
            int M = in.nextInt(); // 비행기의 종류


            for (int i = 1; i <= M; i++) {
                int start = in.nextInt(); // 나라 start
                int end = in.nextInt(); // 나라 end
            }

            System.out.println(N-1);
        }
    }


}
