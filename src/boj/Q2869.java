package boj;

import java.util.Scanner;

public class Q2869 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int day = in.nextInt();
        int night = in.nextInt();
        int goal = in.nextInt();

        int result=((goal-day)/(day-night))+1;
        if ((goal-day)%(day-night)>0) {
            result=result+1;
        }

        System.out.println(result);
    }
}
