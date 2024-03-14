package boj;

import java.util.Scanner;

public class Q2577_숫자의개수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int mul = 1;


        for (int i = 0; i < 3; i++) {
            int num = in.nextInt();
            mul *= num;
        }

        String R = mul + "";
        int[] results = new int[10];


        for (int j = 0; j < R.length(); j++) {
            int i = R.charAt(j) - '0';
            results[i]++;
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(results[i]);
        }

    }
}
