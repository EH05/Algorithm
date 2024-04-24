package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9466 {

    static int[] arr;
    static boolean[] finished;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine()); // 학생의 수

            arr = new int[n + 1];
            finished = new boolean[n + 1];
            visited = new boolean[n + 1];
            result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n + 1; i++) {
                dfs(i);
            }

            System.out.println(n-result);
        }
    }

    public static void dfs(int node) {
        if(finished[node]) return; // 이미 검사한 곳이다.
        if(visited[node]) { // 또 방문한 것이면 사이클 간 것이므로 result++
            finished[node] = true;
            result++;
        }

        // 여기까지 왔다는건 처음 들어왔다는 거

        visited[node] = true;

        dfs(arr[node]);

        finished[node] = true; // 사이클이든 아니든 검사가 끝났으니 true로 표기(불필요한 계산 막기)
        visited[node] = false; // 방문체크한거 초기화
    }
}
