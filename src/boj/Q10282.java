package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10282 {
    static class Node implements Comparable<Node> {
        int c;
        int w;

        public Node(int c, int w) {
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static List<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터의 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성의 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            list = new ArrayList[n + 1];
            dist = new int[n + 1];
            visited = new boolean[n + 1];

            Arrays.fill(dist, Integer.MAX_VALUE);

            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 컴퓨터 a
                int b = Integer.parseInt(st.nextToken()); // 컴퓨터 b
                int s = Integer.parseInt(st.nextToken()); // 컴퓨터b가 감염되면 s초후 컴퓨터 a도 감염됨.

                list[b].add(new Node(a, s));
            }

            dijkstra(c); // 해킹당한 컴퓨터의 번호를 넣기

            int cnt = 0; // 감염된 컴퓨터 수
            int result = 0; // 시간

            for (int i = 1; i < n + 1; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    cnt++;
                    result = Math.max(result, dist[i]);
                }
            }

            System.out.printf("%d %d\n", cnt, result);
        }

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node p = pq.poll();
            if (visited[p.c]) continue;
            visited[p.c] = true;

            for (Node next : list[p.c]) {
                if (dist[next.c] > dist[p.c] + next.w) {
                    dist[next.c] = dist[p.c] + next.w;
                    pq.add(new Node(next.c, dist[next.c]));
                }
            }

        }
    }
}
