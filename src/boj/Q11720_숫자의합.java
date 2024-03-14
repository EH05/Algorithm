package boj;

import java.util.Scanner;

public class Q11720_숫자의합 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        String M = in.next();
        int sum=0;

        for(int i=0;i<N;i++) {
            sum += (M.charAt(i)-'0');
        }

        System.out.println(sum);

    }
}
