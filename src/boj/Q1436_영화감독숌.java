package boj;

import java.util.Scanner;

public class Q1436_영화감독숌 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int num = 0;
        int count = 0;
        int result = 0;

        while (true) {
            String S = Integer.toString(result);
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '6') {
                    count++;
                    if (count == 3) {
                        break;
                    }
                } else {
                    count = 0;
                }
            }


            
            if (count == 3) {
                num++;
            }
            count=0;

            if (num == N) {
                break;
            }
            result++;
        }

        System.out.println(result);
    }
}