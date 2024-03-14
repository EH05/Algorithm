package boj;

import java.util.Scanner;

public class Q2750_선택정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < num - 1; i++) {
            int min = i;
            for (int j = i + 1; j < num; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min]= arr[i];
            arr[i]=temp;
        }
        for (int i = 0; i < num; i++) {
            System.out.println(arr[i]);
        }

    }
}
