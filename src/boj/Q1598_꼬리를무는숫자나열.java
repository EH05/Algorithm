package boj;

import java.util.Scanner;

public class Q1598_꼬리를무는숫자나열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;

        int result = 0;

        result += Math.abs(a/4-b/4);
        result += Math.abs(a%4-b%4);

        System.out.println(result);
    }
}
