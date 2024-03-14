package boj;

import java.util.Scanner;

public class Q2953_나는요리사다 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number = 0;
        int result = 0;

        for (int i = 1; i < 6; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int score = in.nextInt();
                sum += score;
            }
            if (sum>result) {
                number=i;
                result=sum;
            }
        }

        System.out.print(number+" "+result);

    }
}
