package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q10423 {
    static int N; // 도시의 개수
    static int M; // 케이블의 수
    static int K; // 발전소의 개수
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine()); // 발전소가 설치된 도시의 번호
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            parent[num] = 0; // 발전소랑 연결되어 있다는 표시
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(x, y, w));
        }


        int cnt = N - K;
        int result = 0;


        while (!pq.isEmpty()) {
            Edge node = pq.poll();
//            System.out.println(node);

            // 둘이 연결되어 있다면
            if (!union(node.x, node.y)) continue;

            // 연결되어있지않다면
            result += node.w;


            if (--cnt == 0) {
                break;

            }
        }

        System.out.println(result);


    }


    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) return false;

        parent[x] = y;

        return true;
    }

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
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


