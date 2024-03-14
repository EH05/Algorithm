package boj;

import java.util.Scanner;

public class Q10809_알파벳찾기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String S = in.next();

        for (char c = 'a'; c <= 'z'; c++) {
            boolean isExist=false;
            for (int i = 0; i < S.length(); i++) {
                if (c == S.charAt(i)) {
                    System.out.print(i + " ");
                    isExist=true;
                    break;
                }
            }
            if (!isExist) {
                System.out.print(-1+" ");
            }
        }
    }
}