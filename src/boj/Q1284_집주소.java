package boj;

import java.util.Scanner;

public class Q1284_집주소 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            String N = in.next();
            if(N.charAt(0)=='0') {break;}
            int result = N.length() + 1;

            for (int i = 0; i < N.length(); i++) {
                if (N.charAt(i) == '0') {
                    result += 4;
                } else if (N.charAt(i) == '1') {
                    result += 2;
                } else result += 3;
            }

            System.out.println(result);
        }

    }
}
