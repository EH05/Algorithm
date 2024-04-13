package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // Pn
        int M = Integer.parseInt(br.readLine()); // M개의 S
        String S = br.readLine();


        int count = 0; // IOI의 개수
        int result = 0; // 결과값

        for (int i = 1; i < S.length() - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                count++;
                i++;

                if (count == N) {
                    result++;
                }
            } else {
                count = 0;
            }
        }

        System.out.println(result);

    }
}