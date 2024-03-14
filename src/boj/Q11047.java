package boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Q11047 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // N개의 동전
        int K =in.nextInt(); // 가치 K

        int sum = 0; // 가치의 합
        int count = 0; // 동전들의 수

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        for(int idx=arr.length-1; idx>=0; idx--){
            if(sum+arr[idx]>K) continue;
            while(sum+arr[idx]<=K){
                sum+=arr[idx];
                count++;
            }
        }

        System.out.println(count);


    }
}
