package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1647 {
    public static class Edge implements Comparable<Edge> {
        int st, ed, w;

        public Edge(int st, int ed, int w) {
            this.st = st;
            this.ed = ed;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "st=" + st +
                    ", ed=" + ed +
                    ", w=" + w +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        List<Edge>[] list = new ArrayList[V + 1];

        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); // 가중치

            list[a].add(new Edge(a, b, w));
            list[b].add(new Edge(b, a, w));
        }


        boolean[] visited = new boolean[V + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        visited[1] = true;

        for (int i = 0; i < list[1].size(); i++) {
            pq.add(list[1].get(i));
        }

        int pick = 1;
        int ans = 0;
        int max = 0;

        // 가장 가중치가 큰 길만 없앤다.
        while (pick != V) {
            Edge e = pq.poll();
            if (visited[e.ed]) continue;

            ans += e.w;
            max = Math.max(e.w, max);
            visited[e.ed] = true;
            pick++;

            pq.addAll(list[e.ed]);
        }

        System.out.println(ans-max);

    }
}
