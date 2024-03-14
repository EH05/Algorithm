package boj;

import java.util.Scanner;

public class Q1773_폭죽쇼 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 학생 수
        int C = in.nextInt(); // 폭죽쇼가 끝나는 시간

        int[] done = new int[C+1];

        for (int i = 0; i < N; i++) {
            int sec = in.nextInt();
            for (int j = sec; j <= C; ) {
                done[j]++;
                j += sec;
            }
        }

        int count = 0;
        for (int i = 0; i <= C; i++) {
            if (!(done[i] == 0)) {
                count++;
            }
        }
        System.out.println(count);

    }
}
