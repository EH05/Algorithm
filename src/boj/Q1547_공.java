package boj;

import java.util.Scanner;

public class Q1547_공 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[3];
        arr[0] = 1;

        int M = in.nextInt();

        for (int i = 0; i < M; i++) {
            int X = in.nextInt();
            int Y = in.nextInt();

            int temp = arr[X - 1];
            arr[X - 1] = arr[Y - 1];
            arr[Y - 1] = temp;
        }

        for (int i = 0; i < 3; i++) {
            if (arr[i] == 1) {
                System.out.println(i + 1);
            }
        }
    }
}
