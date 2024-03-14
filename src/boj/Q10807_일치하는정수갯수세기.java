package boj;

import java.util.Scanner;

public class Q10807_일치하는정수갯수세기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int arr[] = new int[A];

        for (int i = 0; i < A; i++) {
            arr[i] = in.nextInt();
        }

        int C = in.nextInt();
        int sum=0;

         for (int j = 0; j < A; j++) {
            if (arr[j] == C) {
                sum += 1;
            }
        }

        System.out.println(sum);


    }
}
