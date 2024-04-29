package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q2587 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[5];

        int sum=0;
        for(int i=0; i<5; i++){
            int num = in.nextInt();
            sum+=num;
            arr[i] = num;
        }

        Arrays.sort(arr);

        System.out.println(sum/5);
        System.out.println(arr[2]);

    }
}
