package boj;

import java.util.Scanner;

public class Q2920_음계 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[8];
        int as_count = 0;
        int de_count = 0;

        for (int i = 0; i < 8; i++) {
            arr[i] = i + 1;
        }

        for(int j=0; j<8;j++) {
            int num = in.nextInt();
            if (arr[j] == num) {
                as_count++;
            } else if (arr[7 - j] == num) {
                de_count++;
            }
        }

        if (as_count == 8) {
            System.out.println("ascending");
        } else if (de_count == 8) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
