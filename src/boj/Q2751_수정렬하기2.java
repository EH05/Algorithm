package boj;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q2751_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = sc.nextInt();

        int[] arr= new int[num];

        for(int i=0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0; i<num; i++) {
            sb.append(arr[i]).append('\n');
        }


        System.out.println(sb);
    }
}