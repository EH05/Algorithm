package boj;

import java.util.Scanner;

public class Q2588_곱셈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int F = in.nextInt();

        int H = F / 100;
        int F_2 = F % 100;
        int T = F_2 / 10;
        int F_3 = F_2 % 10;


        System.out.println(N*F_3);
        System.out.println(N*T);
        System.out.println(N*H);
        System.out.println(N*F);

    }

}
