package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //테스트 케이스
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int start = arr[0][0];
        int end = arr[0][1];
        int length = end - start;

        for (int i = 1; i < N; i++) {
            int left = arr[i][0];
            int right = arr[i][1];

            // 이전 범위에 포함된다면 넘어가기
            if (start <= left && right <= end) continue;
                // 시작점만 포함된다면
            else if (left < end) length += right - end;
            // 겹치지 않는다면
            else length += right - left;

            start = left;
            end = right;
        }
        System.out.println(length);


    }
}



