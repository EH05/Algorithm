package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 유저의 수

        int[][] arr = new int[N + 1][N + 1];

        // 배열 초기화 (자기자신으로 가는 경우를 제외하고 최대값으로 설정)
        for (int r = 1; r < N + 1; r++) {
            for (int c = 1; c < N + 1; c++) {
                if (r != c) {
                    arr[r][c] = 987654321;
                }
            }
        }


        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            arr[a][b] = arr[b][a] = 1;
        }


        for (int temp = 1; temp < N + 1; temp++) {
            for (int start = 1; start < N + 1; start++) {
                for (int end = 1; end < N + 1; end++) {
                    if (arr[start][end] > arr[start][temp] + arr[temp][end]) {
                        arr[start][end] = arr[start][temp] + arr[temp][end];
                    }
                }
            }
        }


        // 점수를 저장
        int[] scores = new int[N + 1];

        int minScore = Integer.MAX_VALUE;

        for (int r = 1; r < N + 1; r++) {
            int score = 0;
            for (int c = 1; c < N + 1; c++) {
                if (arr[r][c] != Integer.MAX_VALUE) {
                    score = Math.max(score, arr[r][c]);
                }
            }

            scores[r] = score;
            minScore = Math.min(minScore, score);
        }



        int num = 0; // 사람들의 수
        for (int i = 1; i < N + 1; i++) {
            if (minScore == scores[i]) {
                num++;
                sb.append(i).append(' ');
            }
        }

        System.out.println(minScore + " " + num);
        System.out.println(sb);


    }
}
