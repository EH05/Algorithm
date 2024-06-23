package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1261 {

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return this.num-o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int r=0; r<N; r++){
            String line = br.readLine();
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(String.valueOf(line.charAt(c)));
            }
        }

        int result = 0;


        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0)); // 여기서 시작
        visited[0][0] = true;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        int curR = 0;
        int curC = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.x==N-1 && cur.y==M-1){
                result = cur.num;
                break;
            }

            for(int dir=0; dir<4; dir++){
                curR = cur.x + dr[dir];
                curC = cur.y + dc[dir];

                if(curR<0 || curC<0 || curR>=N || curC >=M) continue;

                if(!visited[curR][curC] && map[curR][curC]==0){
                    visited[curR][curC] = true;
                    pq.add(new Node(curR, curC, cur.num));
                }

                if(!visited[curR][curC] && map[curR][curC]==1){
                    visited[curR][curC] = true;
                    pq.add(new Node(curR, curC, cur.num+1));
                }
            }
        }

        System.out.println(result);


    }
}
