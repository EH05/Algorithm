package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생들의 수
        int M = Integer.parseInt(st.nextToken()); // 두 학생 키를 비교한 횟수

        boolean[][] students = new boolean[N + 1][N + 1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            students[a][b] = true;
        }

        // 연결되어있다면 true 갱신
        for(int k=1; k<N+1; k++) {
            for(int i=1; i<N+1; i++) {
                for(int j=1; j<N+1; j++) {
                    if(students[i][k] && students[k][j]) {
                        students[i][j] = true;
                    }
                }
            }
        }

        int[] cnt = new int[N + 1];

        // 연결되어있는 노드의 수를 센다. 이걸 cnt에 저장
        for (int r = 1; r < N + 1; r++) {
            for (int c = 1; c < N + 1; c++) {
                if (students[r][c] || students[c][r]) {
                    cnt[r]++;
                }
            }
        }


//        System.out.println(Arrays.toString(cnt));

        int result = 0;
        for (int num : cnt) {
            if (num == N - 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}
