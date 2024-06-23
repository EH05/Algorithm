package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14284 {
    static class Node implements Comparable<Node> {
        int idx;
        int w;
        public Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }

    }
    static int n;
    static int m;
    static List<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end,w));
            list[end].add(new Node(start,w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start,end));

    }

    public static int dijkstra(int start, int end){
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(now.w > dist[now.idx]) continue;
            for(Node next: list[now.idx]){
                if(dist[next.idx] > next.w+now.w){
                    dist[next.idx] = next.w+now.w;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    return dist[end];

    }
}
