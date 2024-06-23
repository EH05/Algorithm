package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] start = new int[N];
        String num = br.readLine();
        for(int i=0; i<N; i++){
            start[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        int[] end = new int[N];
        num = br.readLine();
        for(int i=0; i<N; i++){
            end[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }



    }
}
