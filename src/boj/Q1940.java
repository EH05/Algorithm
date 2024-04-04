package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 재료의 개수 N개
        int M = Integer.parseInt(br.readLine()); // 목표 숫자 M

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int left = 0;
        int right = N-1;

        int count = 0;

        while(left<right){
            int sum = arr[left] + arr[right];
            if(sum==M){
                count++;
                left++;
                right--;
            } else if(sum<M){
                left++;
            } else if(sum>M){
                right--;
            }
        }

        System.out.println(count);
    }
}
