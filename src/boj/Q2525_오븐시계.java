package boj;

import java.util.Scanner;

public class Q2525_오븐시계 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();


        int hour=A*60;
        int min=hour+B+C;
        int result_h=(min/60);
        int result_m=(min%60);

        if(result_h>=24) {
            result_h -= 24;
        }


        System.out.println(result_h+" "+result_m);

    }
}
