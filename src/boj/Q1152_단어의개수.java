package boj;

import java.util.Scanner;

public class Q1152_단어의개수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        int cnt = 0;

        str = in.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                cnt++;
            }
        }

        if (str.charAt(0) != ' ' && str.charAt(str.length() - 1) != ' ') {
            cnt = cnt + 1;
        }

        else if (str.charAt(0) == ' ' && str.charAt(str.length() - 1) == ' ') {
            cnt = cnt - 1;
        }

        System.out.println(cnt);

    }
}
