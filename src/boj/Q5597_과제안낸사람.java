package boj;

import java.util.Scanner;

public class Q5597_과제안낸사람 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        boolean[] arr = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int n = in.nextInt();
            arr[n] = true;
        }

        for (int i = 1; i < 31; i++) {
            if (arr[i] == false) {
                System.out.println(i);
            }
        }


    }

}
