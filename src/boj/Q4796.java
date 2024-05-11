package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = 0;
        int result = 0;

        while (true) {
            st = new StringTokenizer(br.readLine());
            num++;

            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0) break;

            result = (V / P) * L + Math.min(L,(V % P));


            System.out.printf("Case %d: %d\n", num, result);

        }
    }
}
