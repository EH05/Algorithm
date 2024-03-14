package boj;

import java.util.Scanner;

public class Q1157_단어공부 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] alpha = new int[26];
        String str = in.nextLine().toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 65;
            alpha[num]++;
        }

        int max = -1;
        char ch = '?';
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > max) {
                max = alpha[i];
                ch = (char) (i + 65);
            } else if (alpha[i] == max) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}
