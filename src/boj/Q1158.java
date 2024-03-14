package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1158 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        sb.append('<');

        Queue<Integer> que = new LinkedList<>();

        int N = in.nextInt(); // 숫자 N까지
        int K = in.nextInt(); // K번째 사람 제거

        for (int i = 1; i <= N; i++) {
            que.add(i);
        }

        int idx = 1;

        while (!que.isEmpty()) {

            if (que.size() == 1) {
                sb.append(que.poll()).append('>');
                break;
            }

            if (idx == K) {
                sb.append(que.poll()).append(',').append(' ');
                idx = 0;
            } else if(idx != K){
                que.add(que.poll());
            }

            idx++;
        }

        System.out.println(sb);
    }
}
