package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1368 {
    static int[] parent;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 논의 수
        weight = new int[N+1];
        parent = new int[N+1];

        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        // 각각 논별 우물의 비용 (새로 팠을때)
        for(int i=1; i<N+1; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 연결할때 드는 비용 넣기
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==0) pq.add(new Edge(0,i,weight[i]));
                else pq.add(new Edge(i,j,num));
            }
        }

        int result = 0;
        while(!pq.isEmpty()){
            Edge node = pq.poll();
//            System.out.println(node);

            if(!union(node.x, node.y)) continue;

//            System.out.println("이거 더할거야");

            result += node.w;
        }

        System.out.println(result);

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
