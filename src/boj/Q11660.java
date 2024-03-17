package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 구해야 하는 횟수
        int[][] dp = new int[N+1][N+1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                dp[r][c] = dp[r][c-1]+Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println();
//        for(int r = 0; r<=N; r++){
//            for(int c = 0; c<=N; c++){
//                System.out.print(dp[r][c]+" ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum=0;
            for(int r=x1; r<=x2; r++){
                sum+=dp[r][y2]-dp[r][y1-1];
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }
}
