package boj;

import java.util.Scanner;

public class Q2720 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt(); // 테케

        for (int tc = 0; tc < T; tc++) {

            StringBuilder sb = new StringBuilder();

            int C = in.nextInt(); // 거스름돈

            int quarter = 0;
            int dime = 0;
            int nickel = 0;
            int penny = 0;

            while (C > 0) {
                if (C >= 25) {
                    quarter++;
                    C -= 25;
                } else if (C >= 10) {
                    dime++;
                    C -= 10;
                } else if (C >= 5) {
                    nickel++;
                    C -= 5;
                } else if (C >= 1) {
                    penny++;
                    C -= 1;
                }
            }


            sb.append(quarter).append(' ').append(dime).append(' ').append(nickel).append(' ').append(penny);

            System.out.println(sb);
        }


    }
}
