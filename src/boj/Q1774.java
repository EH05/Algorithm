package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1774 {
    static Point[] god;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 우주신들의 개수
        int M = Integer.parseInt(st.nextToken()); // 통로의 개수

        god = new Point[N + 1];
        parent = new int[N + 1];
        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            god[i] = new Point(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 이미 연결 된 거 표시
            union(x,y);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i=1; i<N+1; i++){
            for(int j=i+1; j<N+1; j++){
                double w = getDist(i,j);

                pq.add(new Edge(i,j,w));
            }
        }

        double result = 0;

        while(!pq.isEmpty()){
            Edge ed = pq.poll();
            if(!union(ed.s, ed.e)) continue;

            result += ed.w;
        }

        System.out.printf("%.2f",result);


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

    public static double getDist(int a, int b) {
        return Math.sqrt(Math.pow(god[a].x - god[b].x, 2) + Math.pow(god[a].y - god[b].y, 2));
    }

    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        double w;

        public Edge(int s, int e, double w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        public int compareTo(Edge o){
            return Double.compare(this.w, o.w);
        }
    }
}
