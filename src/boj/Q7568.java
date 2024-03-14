package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q7568 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            arr[i][0] = i;
            arr[i][1] = in.nextInt();
            arr[i][2] = in.nextInt();
        }

        int[] rank = new int[N];
        for (int 자신 = 0; 자신 < N; 자신++) {
            int 나보다큰애 = 0;
            for (int 타인 = 0; 타인 < N; 타인++) {
                if (자신 == 타인) continue;
                if (compare(arr[자신], arr[타인]) < 0) {
                    나보다큰애++;
                }
            }
            rank[자신] = 나보다큰애 + 1;
        }


        for(int i = 0; i < N; i++) {
            System.out.print(rank[i] + " ");
        }
    }

    public static int compare(int[] o1, int[] o2) {
        if (o1[1] > o2[1] && o1[2] > o2[2]) {
            return 1;
        } else if (o1[1] < o2[1] && o1[2] < o2[2]) {
            return -1;
        } else {
            return 0;
        }
    }
}
