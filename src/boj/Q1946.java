package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1946 {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Point> pq;
        PriorityQueue<Point> secondPq;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int tc = 0; tc < T; tc++) {
            pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.x, p2.x)); // 서류성적순대로 정렬된 모든 지원자들의 점수

            int num = Integer.parseInt(br.readLine()); // 지원자 수

            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                int score1 = Integer.parseInt(st.nextToken()); // 서류성적 (x)
                int score2 = Integer.parseInt(st.nextToken()); // 면접성적 (y)
                pq.add(new Point(score1, score2));
            }

            while(!pq.isEmpty()){
                System.out.println(pq.poll());
            }


            int count = 1;

            // pq는 서류성적순대로 정렬
            // 서류성적이 하위권이여도 면접 성적순위가 높다면 새로운 secondPq에 들어가기
            Point pre = pq.poll();
            while (!pq.isEmpty()) {
                Point next = pq.poll();
                if (pre.y > next.y) {
                    count++;
                    pre = next;
                }
            }



            System.out.println(count);

        }
    }
}
