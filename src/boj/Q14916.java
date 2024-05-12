package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 거스름돈

        int result = 0;
        while(true){
            if(n%5==0) {
                result += n/5;
                System.out.println(result);
                break;
            } else {
                n-=2;
                result++;
            }

            if(n<0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
