package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q15681 {

    static List<Integer>[] list;
    static int[] childNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int R = Integer.parseInt(st.nextToken()); // 루트의 번호
        int Q = Integer.parseInt(st.nextToken()); // 쿼리의 수

        list = new ArrayList[N+1];

        for(int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
        }
        childNum = new int[N+1];
        Arrays.fill(childNum,1);

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // 자식 수 구하기
        getChildNum(R,-1);

        for(int i=0; i<Q; i++) {
            int root = Integer.parseInt(br.readLine()); // 구해야할 root

            // 자식 수 가져오기
            sb.append(childNum[root]).append('\n');
        }
        System.out.println(sb);
    }

    private static void getChildNum(int node, int parent) {
        // 맨 아래까지 들어가서
        for(int next : list[node]){
            if(next != parent){
                getChildNum(next, node);
            }
        }

        // 부모가 루트노드가 아니라면, 더해주기
        if(parent != -1){
            childNum[parent] += childNum[node];
        }
    }


}