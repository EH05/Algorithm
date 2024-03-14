package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13549_숨박꼭질3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        Queue<Integer> q = new LinkedList<>();

        boolean[] visit = new boolean[100001];
        int[] totalTime = new int[100001];

        q.add(N);
        visit[N] = true;

        int cnt; // 현재 단계에서 탐색해야 할 노드의 개수
        int next = 1; // 현재 노드에서 이동할 수 있는 노드의 개수
        int result = 0;

        run: while(true) {
            if(N==K) {
                break;
            }
            cnt = next;
            next = 0;

            while(cnt != 0) {
                int X = q.poll();

                int [] cal = {X*2, X-1, X+1}; // X*2에 우선순위 줌.

                for(int d=0; d<3; d++) {
                    int nx = cal[d];


                    if(nx<0 || nx>= 100001) continue;

                    if(!visit[nx]) {
                        q.add(nx);
                        visit[nx] = true;
                        next++;
                        if(d==0){
                            totalTime[nx] = totalTime[X];
                        } else if(d==1 || d==2) {
                            totalTime[nx] = totalTime[X]+1;
                        }
                    }

                    if(nx == K) {
                        result = nx;
                        break run;
                    }

                }
                cnt--;
            }
        }
        System.out.println(totalTime[result]);
    }
}
