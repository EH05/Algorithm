package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Q1707 {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        // 1팀과 2팀으로 나눠서 생각하자.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        All:
        for (int tc = 0; tc < K; tc++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점의 개수
            int E = Integer.parseInt(st.nextToken()); // 간선의 개수

            List<Integer>[] list = new List[V + 1];

            for (int i = 0; i < V + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

//            for(int i=1; i<V+1; i++){
//                System.out.println(list[i]);
//            }
//            System.out.println("=============");

            int[] visited = new int[V + 1];

            for (int i = 1; i < V + 1; i++) {
                Queue<Integer> que = new LinkedList<>();

                if (visited[i] == 0) {
                    que.add(i);
                    visited[i] = 1;
                }


                while (!que.isEmpty()) {
                    int cur = que.poll();

                    for (int node : list[cur]) {
                        if (visited[node] == 0) {
                            que.add(node);
                            if (visited[cur] == 1) {
                                visited[node] = 2;
                            } else if (visited[cur] == 2) {
                                visited[node] = 1;
                            }
                        }

                        // 둘이 번호가 같다면 (같은 팀이라면)
                        if (visited[node] == visited[cur]) {
                            sb.append("NO").append("\n");
                            continue All;
                        }

                    }
                }

            }

            sb.append("YES").append("\n");

        }

        System.out.println(sb);
    }
}
