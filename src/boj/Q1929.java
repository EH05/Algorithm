package boj;

import java.util.Scanner;

public class Q1929 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M = in.nextInt(); // M 이상
        int N = in.nextInt(); // N 이하

        for(int i=M; i<=N; i++) {
            if(i<=3) {
                System.out.println(i);
                continue;
            }
            if(!(i%2==0) && !(i%3==0)) {
                System.out.println(i);
            }
        }

    }
}
