package boj;

import java.util.Scanner;

public class Q15829_Hashing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int L = in.nextInt();
        String str = in.next();

        long sum = 0;
        long r = 1;
        int num = 1234567891;

        for (int i = 0; i < L; i++) {
            int j = (str.charAt(i) - 96)%num;

            sum+=(j*r)%num;
            r=(r*31)%num;

        }
        System.out.println(sum%num);
    }
}