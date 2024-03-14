package boj;

import java.util.Scanner;

public class Q5717_상근이의친구들 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            int M = in.nextInt();
            int F = in.nextInt();

            if(M==0 && F==0) {
                break;
            }

            System.out.println(M+F);
        }
    }
}
