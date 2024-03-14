package boj;

import java.util.Scanner;

public class Q1703_생장점 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int year = in.nextInt();
            int tree = 0;
            int result = 1;
            if (year == 0) {
                break;
            }

            for (int i = 0; i < year; i++) {
                int factor = in.nextInt();
                int delete = in.nextInt();

                tree = result * factor;
                result = tree-delete;

            }

            System.out.println(result);
        }
    }
}
