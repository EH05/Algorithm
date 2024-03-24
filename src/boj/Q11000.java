package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine()); // N개의 수업

        Point[] lectures = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            lectures[i] = new Point(S, T);
        }

        // 시작 시간을 기준으로 오름차순 정렬 ( 같다면 종료시간을 기준으로 오름차순)
        Arrays.sort(lectures, (p1, p2) -> p1.x == p2.y ? p1.y - p2.y : p1.x - p2.x);


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].y);

        // 우선 순위 큐에서 가장 작은 종료시간과 현재 강의의 시작 시간 비교
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].x) {
                pq.poll();
            }
            pq.add(lectures[i].y);
        }

        System.out.println(pq.size());


    }
}

//5
//1 2
//2 3
//3 6
//5 9
//2 5