package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q16398 {
    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];

        for(int i=1; i<n+1; i++){
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int r=0; r<n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c<n; c++){
                int w = Integer.parseInt(st.nextToken());
                if(r==c) continue;
                pq.add(new Edge(r,c,w));
            }
        }

        long ans = 0;
        int cnt = 0;

        while(!pq.isEmpty()){
            Edge ed = pq.poll();
            if(!union(ed.x, ed.y)) continue;

            ans += ed.w;
            if(++cnt == n-1) break;

        }

        System.out.println(ans);

    }

    static int find(int a){
        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x==y) return false;

        parent[x] = y;
        return true;
    }

    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        public int compareTo(Edge o){
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
