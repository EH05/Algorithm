package boj;

import java.util.Scanner;

public class Q16953 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();

        int count = 0;
        while (B != A) {
            if (B < A) {
                count = -2;
                break;
            } else if (B % 10 == 1) {
                B = B / 10;
                count++;
            } else if (B % 2 == 0) {
                B = B / 2;
                count++;
            } else if (B % 2 != 0) {
                count = -2;
                break;
            }
        }
        System.out.println(count + 1);
    }
}
