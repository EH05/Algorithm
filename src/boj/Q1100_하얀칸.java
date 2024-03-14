package boj;

import java.util.Scanner;

public class Q1100_하얀칸 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;

        boolean iswhite = true;

        for (int i = 0; i < 8; i++) {
            String result = in.next();
            for (int j = 0; j < 8; j++) {
                if (iswhite && j % 2 == 0 && result.charAt(j)=='F') {
                    count++;
                } else if (!iswhite && j % 2 == 1 && result.charAt(j)=='F') {
                    count++;
                }
            }

            iswhite = !iswhite;

        }
        System.out.println(count);

    }
}