package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q13418 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 건물의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수

        parent = new int[N + 1];


        PriorityQueue<Edge> minPq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.w, e2.w)); // 최단
        PriorityQueue<Edge> maxPq = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.w, e1.w)); // 최장


        for (int i = 0; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            minPq.add(new Edge(x, y, w));
            maxPq.add(new Edge(x, y, w));
        }

        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        int minCnt = 0;
        while (!minPq.isEmpty()) {
            Edge ed = minPq.poll();
            if (!union(ed.x, ed.y)) continue;

            // 오르막길이라면
            if (ed.w == 0) {
                minCnt++;
            }
        }


        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        int maxCnt = 0;
        while (!maxPq.isEmpty()) {
            Edge ed = maxPq.poll();
            if (!union(ed.x, ed.y)) continue;

            // 오르막길이라면
            if (ed.w == 0) {
                maxCnt++;
            }
        }

//        System.out.println(Math.pow(maxCnt,2));
//        System.out.println(Math.pow(minCnt,2));

        System.out.println((int)(Math.pow(minCnt,2))-(int)Math.pow(maxCnt,2));

    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x == y) return false;

        parent[x] = y;
        return true;
    }

    static class Edge {
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }


        @Override
        public String toString() {
            return "Edge{" +
                    "x=" + x +
                    ", y=" + y +
                    ", w=" + w +
                    '}';
        }
    }
}
