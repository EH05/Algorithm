package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q13023 {
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean possible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        list = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        possible = false;

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (possible) break;
        }

        System.out.println(possible? 1 : 0);


    }

    // idx는 i번째 사람, cnt는 친구의 수
    public static void dfs(int idx, int cnt) {
        if(cnt==5){
            possible = true;
            return;
        }

        visited[idx] = true;

        for(int next:list[idx]){
            if(!visited[next]){
                dfs(next, cnt+1);
            }
        }

        visited[idx] = false;


    }
}
