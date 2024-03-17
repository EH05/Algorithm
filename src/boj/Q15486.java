package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15486 {

    static class Work {
        int time;
        int money;

        public Work(int time, int money) {
            this.time = time;
            this.money = money;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Work[] works = new Work[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            works[i] = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);
        for (int day = 1; day <= N; day++) {
            System.out.println("day="+day);
            // day-1 까지 수행할 경우의 최대이익과 day까지 수행할 경우의 최대 이익 비교하여 더 큰값을 day의 최대이익으로
            dp[day] = Math.max(dp[day - 1], dp[day]);
            Work work = works[day];
            // 해당 업무의 마감일
            int deadline = day + work.time - 1;
            System.out.println("deadline="+deadline);
            if (deadline > N) continue;
            // 이 일을 수행한다면 추후 얻는 이익이 더 클경우 dp에 저장
            dp[deadline] = Math.max(dp[day - 1] + work.money, dp[deadline]);
            System.out.println(Arrays.toString(dp));
            System.out.println("---------------");
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}
