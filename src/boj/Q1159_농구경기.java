package boj;

import java.util.Scanner;

public class Q1159_농구경기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] arr = new int[26];

        for (int i = 0; i < N; i++) {
            String name = in.next();
            int first = name.charAt(0) - 97;
            arr[first]++;
        }

        boolean isover = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 5) {
                System.out.print((char)(i+97));
                isover = false;
            }
        }
        if(isover) {
            System.out.println("PREDAJA");
        }
    }
}
