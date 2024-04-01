package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Point> pq = new PriorityQueue<>(((o1, o2) -> o1.y==o2.y ? o1.x - o2.x :o1.y - o2.y));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.add(new Point(x, y));
        }

        int count = 1;// 결과값. 회의의 개수

        Point curr = pq.poll();

        while (!pq.isEmpty()) {
            Point next = pq.peek();
            if (!pq.isEmpty() && curr.y > next.x) {
                pq.poll();
            } else if (!pq.isEmpty() && curr.y <= next.x) {
                count++;
                curr = pq.poll();
            }
        }

        System.out.println(count);
    }
}
