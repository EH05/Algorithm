package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 책의 개수
        int M = Integer.parseInt(st.nextToken()); // 최대 무게



        if(N==0){
            System.out.println(0);
        } else if(N>0) {
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = 1;

            int sum = 0;
            for(int num :arr){
                sum+=num;
                if(sum>M){
                    count++;
                    sum=num;
                }
            }
            System.out.println(count);
        }


    }
}
