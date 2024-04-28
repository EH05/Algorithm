package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3584 {
    static int[] parent;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine()); // 노드의 수
            parent = new int[10001]; // 인덱스가 자식, 값이 부모
            visited = new boolean[10001]; // 해당
            for (int n = 0; n < N - 1; n++) {
                st = new StringTokenizer(br.readLine()); // 간선 정보
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
            }
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result = 0;
            getParent(a, b);

            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    public static void getParent(int a, int b) {
        // 부모가 없을때까지
        while (true) {
            visited[a] = true; // 만난 부모는 다 방문처리
            if (parent[a] == 0) {
                break;
            }
            a = parent[a];
        }

        while (true) {
            if (visited[b]) {
                result = b;
                break;
            }
            b = parent[b];
        }
    }
}