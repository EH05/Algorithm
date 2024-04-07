package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Q11724 {

    static int count = 0;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }


        for(int node=1; node<=N; node++){
            if(!visited[node]) {
                count++;
                dfs(node);
            }
        }

        System.out.println(count);

    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int next : list[node]){
            if(visited[next]) {
                continue;
            }
            dfs(next);
        }
    }
}
