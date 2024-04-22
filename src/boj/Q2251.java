package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2251 {
    static int A, B, C;
    static boolean[][] visited = new boolean[201][201]; // A,B의 물의 양(방문체크)
    static boolean[] ans = new boolean[201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); // 첫번째 물통
        B = Integer.parseInt(st.nextToken()); // 두번째 물통
        C = Integer.parseInt(st.nextToken()); // 세번째 물통

        // 물의 양을 넘겨준다.
        dfs(0, 0, C);

        for (int i = 0; i < 201; i++) {
            if (ans[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void dfs(int aw, int bw, int cw) {
        // 이 경우를 고려했었다면 탐색 중단
        if (visited[aw][bw]) {
            return;
        }

//        System.out.println("aw= "+aw+", bw= "+bw+", cw= "+cw);

        // 물통 A가 비어있다면
        if (aw == 0) {
            ans[cw] = true;
        }

        visited[aw][bw] = true;

        // 물통 A -> 물통 B로 옮김
        if (aw + bw > B) {
            dfs((aw + bw) - B, B, cw);
        } else {
            // A를 비울수 있다면 비운다.
            dfs(0, aw + bw, cw);
        }

        // 물통 B -> 물통 A로 옮김
        if (bw + aw > A) {
            dfs(A, (bw + aw) - A, cw);
        } else {
            dfs(bw + aw, 0, cw);
        }

        // 물통 C -> 물통 A로 옮김
        if (cw + aw > A) {
            dfs(A, bw, (cw + aw) - A);
        } else {
            dfs(cw + aw, bw, 0);
        }

        // 물통 C -> 물통 B로 옮김
        if (cw + bw > B) {
            dfs(aw, B, (cw + bw) - B);
        } else {
            dfs(aw, cw + bw, 0);
        }

        dfs(aw, 0, bw + cw);
        dfs(0, bw, aw + cw);
    }
}
