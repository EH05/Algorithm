package boj;

import java.util.Scanner;

public class Q5532_방학숙제 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int L = in.nextInt(); // 방학 일수
        int A = in.nextInt(); // 국어 페이지
        int B = in.nextInt(); // 수학 페이지
        int C = in.nextInt(); // 국어 최대 페이지
        int D = in.nextInt(); // 수학 최대 페이지

        int language = A / C;
        int math = B / D;
        int day = 0;

        if (A % C > 0) {
            language++;
        }

        if (B % D > 0) {
            math++;
        }

        if (language >= math) {
            day = L - language;
        } else {
            day = L - math;
        }


        System.out.println(day);
    }
}
