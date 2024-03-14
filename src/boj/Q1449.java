package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
        int L = Integer.parseInt(st.nextToken()); // 테이프의 길이

        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }


        while (!pq.isEmpty()) {
            int tape = L - 1;
            int tmp = pq.poll();
            while (tape >= 0) {
                if(pq.isEmpty()){
                    count++;
                    break;
                }

                if (!pq.isEmpty() && pq.peek() - tmp <= tape) {
                    pq.poll();
                }

                if (!pq.isEmpty() && pq.peek() - tmp>tape){
                    count++;
                    break;
                }
            }

        }


        System.out.println(count);
    }


}

