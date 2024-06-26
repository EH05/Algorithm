package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 레벨의 수
        int[] score = new int[N];
        for(int i=0; i<N; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for(int i= N-2; i>=0; i--){
            while(score[i+1]<=score[i]){
                score[i]--;
                result++;
            }
        }

        System.out.println(result);
    }
}
