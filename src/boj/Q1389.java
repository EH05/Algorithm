package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Q1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 유저의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        List<Integer>[] list = new ArrayList[N+1];

        for(int i = 0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // 케빈 베이컨의 수를 저장할 배열
        int[] numbers = new int[N+1];

        for(int i = 1; i<N+1; i++){
            boolean[] visited = new boolean[N+1];
            visited[i] = true;
            int number = 0;


            Queue<Point> que = new LinkedList<>(); // que에 부모 i와 그 부모의 깊이 담음
            que.add(new Point(i,1));

            while(!que.isEmpty()) {
                int qsize = que.size();
                for (int j = 0; j < qsize; j++) {
                    Point cur = que.poll();
                    for (int node : list[cur.x]) {
                        if (!visited[node]) {
                            number+=cur.y;
                            que.add(new Point(node,cur.y+1));
                            visited[node] = true;
                        }
                    }
                }
            }

            numbers[i]  = number;

        }


        int result = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=1; i<N+1; i++){
            if(numbers[i]<result){
                result = numbers[i];
                ans = i;
            }
        }

        System.out.println(ans);


    }
}
