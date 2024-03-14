package boj;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q2075_N번째큰수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = in.nextInt(); // N*N의 표

        for (int i = 0; i < N; i++) {
            for(int j=0; j<N; j++) {
                pq.offer(in.nextInt());
            }
        }

        for(int i=0; i<N-1; i++){
            pq.poll();
        }

        System.out.println(pq.poll());


    }
}
