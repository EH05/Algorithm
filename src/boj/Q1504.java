package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1504 {

    public static class Node implements Comparable<Node> {
        int end, w;

        public Node(int end, int w) {
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "end=" + end +
                    ", w=" + w +
                    '}';
        }
    }

    static int N, E;
    static List<Node>[] adjList; // 인접리스트
    static int[] dist;
    static boolean[] check;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        adjList = new ArrayList[N + 1];
        dist = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < N+1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, weight));
            adjList[end].add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int point1 = Integer.parseInt(st.nextToken());
        int point2 = Integer.parseInt(st.nextToken());

        int case1 = 0;
        case1 += dijkstra(1, point1);
        case1 += dijkstra(point1, point2);
        case1 += dijkstra(point2, N);

        int case2 = 0;
        case2 += dijkstra(1, point2);
        case2 += dijkstra(point2, point1);
        case2 += dijkstra(point1, N);

        int result = (case1 >= INF && case2 >= INF) ? -1 : Math.min(case1, case2);

        System.out.println(result);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (check[now.end]) continue;
            check[now.end] = true;

            // 간선 탐색
            for (Node next : adjList[now.end]) {
                if(dist[next.end] > next.w + now.w) {
                    dist[next.end] = next.w + now.w;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }

        return dist[end];
    }
}
