package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken()); // 게임 횟수
        int Y = Integer.parseInt(st.nextToken()); // 이긴 게임

        int right = 1000000000;
        int left = 0;
        int target = (int)((long)Y * 100 / X);
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int tempY = mid+Y;
            int tempX = mid+X;
            int newTarget = (int)((long)tempY * 100 / tempX);
            if (newTarget != target) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(answer);
    }

}

