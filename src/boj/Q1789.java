package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());
        long sum = 0;
        int count = 1;

        while(true){
            if(sum>num) break;
            sum+=count;
            count++;
        }

        System.out.println(count-2);
    }
}
