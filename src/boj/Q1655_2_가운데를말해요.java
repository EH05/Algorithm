package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1655_2_가운데를말해요 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> minOfMax = new PriorityQueue<>();
        PriorityQueue<Integer> maxOfMin = new PriorityQueue<>(Collections.reverseOrder());

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();

        for(int i=0; i<N; i++){
            int num = in.nextInt();

            if(minOfMax.size() == maxOfMin.size()){
                maxOfMin.offer(num);
            } else {
                minOfMax.offer(num);
            }

            if(!minOfMax.isEmpty() && !maxOfMin.isEmpty()){
               if(minOfMax.peek()<maxOfMin.peek()){
                   int temp = minOfMax.poll();
                   minOfMax.offer(maxOfMin.poll());
                   maxOfMin.offer(temp);
               }
            }

            sb.append(maxOfMin.peek()).append('\n');

        }

        System.out.println(sb);
    }
}
