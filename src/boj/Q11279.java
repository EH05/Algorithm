package boj;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q11279 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();

        for(int i=0; i<N; i++){
            int num = in.nextInt();

            if(num==0){
                if(pq.isEmpty())  sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            } else {
                pq.offer(num);
            }
        }

        System.out.println(sb);
    }
}
