package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4470_줄번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String word = br.readLine();

            System.out.print(i);
            System.out.print("."+" "+word);
            System.out.println();
        }
    }
}
