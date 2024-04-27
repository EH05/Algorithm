package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가의 수
            int M = Integer.parseInt(st.nextToken()); // 비행기의 종류

            while(M>0){
                st = new StringTokenizer(br.readLine());
                M--;
            }

            System.out.println(N-1);
        }
    }
}
