package boj;

import java.util.Scanner;

public class Q2750_버블정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < num; i++) {
            System.out.println(arr[i]);
        }

    }
}
