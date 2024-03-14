package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reversepq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb= new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // N개의 정수

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            //
            if (pq.size() == reversepq.size()) {
                reversepq.offer(num);
            } else pq.offer(num);

            // 만약 오름차순 queue의 최대값이 내림차순 eueue의 최대값보다 작다면 교환하기
            if(!pq.isEmpty() && !reversepq.isEmpty()){
                if(pq.peek() < reversepq.peek()){
                    int temp = pq.poll();
                    pq.offer(reversepq.poll());
                    reversepq.offer(temp);
                }
            }

            sb.append(reversepq.peek()).append('\n');
        }
        System.out.println(sb);
    }
}
// 숫자가 추가될때마다 중간값이 계속해서 reversepq의 최댓값
// 내림차순
// 5 reversepq.peek()
// 2
// 1
// -99

// 오름차순 // 항상 이게 더 커야함.
// 5 pq.peek()
// 7
// 10



