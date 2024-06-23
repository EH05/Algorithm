package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q18427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N번의 학생
        int M = Integer.parseInt(st.nextToken()); // 최대 M개의 블록
        int H = Integer.parseInt(st.nextToken()); // 높이 H인 탑

        List<Integer>[] list = new ArrayList[N + 1];
        int[][] dp = new int[N + 1][H + 1]; // 학생별 특정 높이 도달 경우의 수 저장

        // 학생별(i) 블록 입력받기
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                list[i].add(num);
            }
        }

        // 학생별 블록을 안내서 높이 0을 만드는 경우의 수 +1
        for (int i = 1; i < N; i++) {
            dp[i][0] = 1;
        }

        // 첫번째 학생이 가진 블록으로 만들 수 있는 높이 우선 +1
        for (int num : list[1]) {
            dp[1][num] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < H + 1; j++) {
                dp[i][j] = dp[i - 1][j]; // 우선 이전 학생에서의 경우의 수 가져옴
                for (int block : list[i]) {
                    // 이전학생의 [j-block] 높이에 지금학생의 block을 더하면 j 높이가 됨.
                    if (j - block < 0) continue;
                    dp[i][j] += dp[i-1][j-block];
                    dp[i][j] %= 10007;
                }
            }
        }

        System.out.println(dp[N][H]);


    }
}
