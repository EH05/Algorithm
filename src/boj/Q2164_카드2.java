package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2164_카드2 {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for(int i=1; i<=N; i++) {
            que.offer(i);
        }

        while(que.size()>1) {
            que.poll();
            que.offer(que.poll());
        }
        System.out.println(que.poll());
    }
}
