package boj;

import java.util.Scanner;

public class Q9086 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            String result = in.next();
            System.out.print(result.charAt(0));
            System.out.println(result.charAt(result.length() - 1));
        }
    }
}
