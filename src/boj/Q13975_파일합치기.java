package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q13975_파일합치기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = in.nextInt();

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i=0; i<N; i++){
                pq.offer(in.nextLong());
            }

            long result = minCost(pq);

            System.out.println(result);

        }
    }


    public static long minCost(PriorityQueue<Long> pq){

        long minCost = 0;

        while(pq.size()>1){
            long sum = pq.poll() + pq.poll();
            minCost += sum;
            pq.offer(sum);
        }

        return minCost;
    }
}
