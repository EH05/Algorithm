package boj;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1781_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> deadline = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> ramyeon = new PriorityQueue<>(Collections.reverseOrder());

        // 둘 다 내림차순 우선순위 큐로 입력받는다.
        // 다 입력받은후, deadline.peek()의 수만큼 ramyeon.poll()의 수를 더한다.

        int N = in.nextInt(); // 숙제의 개수

        for(int i=0; i<N; i++){
            int dead = in.nextInt(); // 데드라인
            int num = in.nextInt(); // 라면 갯수

            deadline.offer(dead);
            ramyeon.offer(num);
        }

        int sum = 0;

//        System.out.println(deadline.peek());

        for(int i=0; i<deadline.peek(); i++){
            sum += ramyeon.poll();
//            System.out.println("sum = " + sum);
        }

        System.out.println(sum);





    }
}
