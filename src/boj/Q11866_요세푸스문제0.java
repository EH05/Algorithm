package boj;

import java.util.Scanner;

public class Q11866_요세푸스문제0 {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int[] result = new int[n];
        int arrIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int m = 0; m < k; arrIndex++) {
                if (arrIndex >= n) {
                    arrIndex = arrIndex - n;
                }
                if (arr[arrIndex] != 0) {
                    m++;
                }
            }
            result[i] = arr[arrIndex - 1];
            arr[arrIndex - 1] = 0;
        }

        System.out.print("<");

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
            if (i != n - 1) {
                System.out.print("," + " ");
            }
        }
        System.out.print(">");
    }

}