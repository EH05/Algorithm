package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Q20040 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int idx = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 사이클이라면
            if (!union(x, y)) {
//                System.out.println(Arrays.toString(parent));
                idx = i + 1;
                break;
            }
        }

        System.out.println(idx);


    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x == y) return false;


        parent[x] = y;

        return true;
    }
}
