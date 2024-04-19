package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q5567 {

    static int n, m;
    static List<Integer>[] list;
    static boolean[] vistied;

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 동기의 수
        m = Integer.parseInt(br.readLine()); // 리스트의 길이

        list = new ArrayList[n+1];


        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        vistied = new boolean[n + 1];
        vistied[1] = true;

        // 상근이(1)의 친구 or 친구의 친구 찾기
        // 친구의 depth는 0, 친구의 친구 depth는 1
        for (int i : list[1]) {
            getCount(i, 0);
        }

        for(int i=2; i<n+1; i++){
            if(vistied[i]) {
                count++;
            }
        }

        System.out.println(count);


    }

    public static void getCount(int num, int depth) {
//        System.out.println("list["+num+"] = "+list[num]);
        // 친구의 친구의 친구이면 return;
        if (depth == 2 ) {
            return;
        }

        for (int i :list[num]) {
            vistied[num] = true;
            getCount(i, depth + 1);
        }


    }
}
