package boj;

import java.util.Scanner;

public class Q2475_검증수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int sum = 0;

        for(int i=0; i<5; i++) {
            int num = in.nextInt();
            int mul= num*num;
            sum += mul;
        }

        System.out.println(sum%10);
    }
}
