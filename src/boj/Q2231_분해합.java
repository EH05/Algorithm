package boj;

import java.util.Scanner;

public class Q2231_분해합 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for (int i = 1; i <= N; i++) {
            int result=i;
            int sum=0;
            while(result>=1) {
                sum += result%10;
                result=result/10;
            }

            if(i+sum==N) {
                System.out.println(i);
                break;
            } else if(i == N) {
                System.out.println(0);
            }
        }


    }
}