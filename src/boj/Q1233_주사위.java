package boj;

import java.util.Scanner;

public class Q1233_주사위 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int S1 = in.nextInt();
        int S2 = in.nextInt();
        int S3 = in.nextInt();

        int[] arr = new int[81];

        for (int i = 1; i <= S1; i++) {
            int sum = 0;
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    sum = i + j + k;
                    arr[sum]++;
                }
            }
        }

        int result = 0;


        for (int i = 0; i < 80; i++) {
            if (arr[i] < arr[i + 1]) {
                result=i+1;
                if(arr[i]==arr[i+1]) {
                    result=i;
                }
            }
        }

        System.out.println(result);


    }
}
