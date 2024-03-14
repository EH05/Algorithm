package boj;

import java.util.Scanner;

public class Q4101_크냐 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int f = in.nextInt();
            int s = in.nextInt();

            if (f == 0 && s == 0) {
                break;
            }

            if (f > s) {
                System.out.println("Yes");
            } else System.out.println("No");

        }
    }
}
