import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 남은 N일
        int M = Integer.parseInt(st.nextToken()); // 챕터의 수

        int[] day = new int[M+1];
        int[] page = new int[M+1];

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());

            day[i] = Integer.parseInt(st.nextToken());
            page[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[M+1][N+1]; // dp[i][j]는 i번까지 고려했을때 소요한 j일동안 읽을 수 있는 페이지의 최대값

        for(int i=1; i<M+1; i++){
            for(int j=1; j<N+1; j++){
                dp[i][j] = dp[i-1][j];

                if(day[i]<=j){
                    dp[i][j] = Math.max(dp[i-1][j-day[i]]+page[i],dp[i][j]);
                }
            }
        }
        System.out.println(dp[M][N]);


    }
}
