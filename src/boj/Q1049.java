package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N개의 줄
        int M = Integer.parseInt(st.nextToken()); // M개의 브랜드

        int minSix = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            minSix = Math.min(minSix,six);
            minOne = Math.min(minOne,one);
        }


        int result = Math.min(minOne*N,Math.min(minSix*(N/6)+minOne*(N%6),minSix*(N/6)+minSix));

        System.out.println(result);



    }
}
