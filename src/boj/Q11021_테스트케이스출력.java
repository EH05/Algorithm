package boj;

import java.util.Scanner;

public class Q11021_테스트케이스출력 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int sum = A + B;
            System.out.println("Case #" + (i + 1) + ": " + sum);
        }
    }
}
