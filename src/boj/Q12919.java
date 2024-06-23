package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12919 {

    static String S;
    static String T;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(result);
    }

    public static void dfs(String str) {
//        System.out.println("str= "+str);

        if (str.length() == S.length()) {
            if (str.equals(S)) {
                result = 1;
            }
            return;
        }

        // 맨 뒤가 A면
        if (str.charAt(str.length() - 1) == 'A') {
            dfs(str.substring(0, str.length() - 1));
            if(result==1)
                return;
        }


//        System.out.println("str= "+str);

        if (str.charAt(0) == 'B') {
            // 첫번째 문제 제거 -> 뒤집기 -> String 변환
            dfs(new StringBuilder(str.substring(1)).reverse().toString());
        }

    }
}
