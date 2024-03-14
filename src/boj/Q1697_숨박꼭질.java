package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697_숨박꼭질 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<>();

        int N = in.nextInt(); // 수빈이의 위치
        int K = in.nextInt(); // 동생의 위치

        boolean[] visit = new boolean[100001];

        q.add(N);
        visit[N] = true;

        int time = 0; // 동생한테 갈 때까지 걸리는 시간
        int cnt; // 현재 단계에서 탐색해야할 노드의 개수
        int next = 1; // 현재 노드에서 이동할 수 있는 노드의 개수

        run: while (true) {
            if(N==K) {
                break;
            }

            cnt = next;
            next = 0;
            time++;


            while (cnt != 0) {
                int X = q.poll();

                int[] cal = { X - 1, X + 1, X * 2 };
                for (int d = 0; d < 3; d++) {
                    int nx = cal[d];

                    if (nx == K)
                        break run; // 만약 수빈이가 동생의 위치에 도달했다면 종료
                    if (nx < 0 || nx >= 100001)
                        continue;
                    if (!visit[nx]) {
                        q.add(nx);
                        visit[nx]=true;
                        next++;
                    }
                }

                cnt--;

            }
        }

        System.out.println(time);
    }
}
