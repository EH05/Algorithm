package boj;

import java.util.Scanner;

public class Q10818_정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int num = in.nextInt();
        int max = num;
        int min = num;

        for (int i = 1; i < N; i++) {
            int num_2 = in.nextInt();
            if (num_2 > max) {
                max = num_2;
            }
            if (num_2 < min) {
                min = num_2;
            }
        }

        System.out.println(min + " " + max);

    }
}
