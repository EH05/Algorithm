package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2056 {
    static int N;
    static List<Integer>[] list;
    static int[] indegree; // 진입차수
    static int[] time; // 시간 저장
    static int[] total; // 총 시간 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 작업 N개

        list = new ArrayList[N + 1];
        indegree = new int[N + 1];
        time = new int[N + 1];
        total = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new ArrayList<>();
            time[i] = Integer.parseInt(st.nextToken());
            indegree[i] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < indegree[i]; j++) {
                int pre = Integer.parseInt(st.nextToken());
                list[pre].add(i);
            }
        }

        for(int i=1; i<N+1; i++){
            System.out.println(list[i].toString());
        }

        topologySort();

        System.out.println(Arrays.toString(time));
        System.out.println(Arrays.toString(total));

        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            result = Math.max(result, total[i]);
        }

        System.out.println(result);
    }

    public static void topologySort() {
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) { // 진입 차수가 0이라면
                que.add(i);
                total[i] = time[i];
            }
        }

        while (!que.isEmpty()) {
            System.out.println("while문 시작-----------");
            int cur = que.poll();
            System.out.println("cur="+cur);

            for (int next : list[cur]) {
                total[next] = Math.max(total[cur] + time[next], total[next]);

                System.out.println(Arrays.toString(total));

                indegree[next]--;
                if (indegree[next] == 0) {
                    que.add(next);
                }
            }

        }
    }
}
