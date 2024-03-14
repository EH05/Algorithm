package boj;

import java.util.Scanner;

public class Q2884_알람시계 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int H = in.nextInt();
        int M = in.nextInt();

        if (H==0) {
            H=24;
        }
        int result=(H*60)+M-45;
        int hour=result/60;
        int min=result%60;

        if (hour==24) {
            hour=0;
        }

        System.out.println(hour+" "+min);
    }
}
