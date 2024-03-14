package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q11651_좌표정렬하기2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                else
                    return o1[1]-o2[1];
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);

    }
}
