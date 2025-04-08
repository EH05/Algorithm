import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        char[] s1 = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        char[] s2 = st.nextToken().toCharArray();

        int[][] dp = new int[s1.length + 1][s2.length + 1];

        int max = 0;
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        if(max != 0) {
            for(int i = s1.length, j = s2.length; i >= 1 && j >= 1;) {
                if(s1[i - 1] == s2[j - 1]) {
                    sb.append(s1[i - 1]);
                    i--;
                    j--;
                } else {
                    if(dp[i - 1][j] == dp[i][j]) {
                        i--;
                    } else {
                        j--;
                    }
                }
            }
        }

        System.out.println(max);
        if (max != 0) {
            System.out.println(sb.reverse());
        }
    }

    private static int stoi(String v) {
        return Integer.parseInt(v);
    }
}