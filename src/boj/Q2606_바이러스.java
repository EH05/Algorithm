package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2606_바이러스 {
    static List<Integer>[] list;
    static boolean visit[];
    static int count=0; // 바이러스 걸리는 컴퓨터의수

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt(); // 컴퓨터의 수
        int T = in.nextInt(); // 컴퓨터쌍의 수
        list = new ArrayList[num + 1];
        visit = new boolean[num+1];


        for (int tc = 1; tc <= num; tc++) {
            list[tc] = new ArrayList<>();
        }

        for (int i = 0; i < T; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            list[a].add(b);
            list[b].add(a);
        }


        System.out.println(dfs(1));

    }

    // 연결리스트 탐색하면서 연결된 컴퓨터중에 방문하지 않은 컴퓨터 개수 counting
    public static int dfs(int i){
        visit[i] = true;
        for(int k : list[i]) {
            if(!visit[k]){
                count++;
                dfs(k);
            }
        }
        return count;
    }
}
