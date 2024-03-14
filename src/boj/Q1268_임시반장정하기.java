package boj;

import java.util.Scanner;

public class Q1268_임시반장정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[][] studentNum = new int[N][7];
        boolean[][] alreadyChecked = new boolean[N][N];  // 중복되는 같은 반 학생은 true로

        // 주어진 표 작성
        // [i][0] 에 학생 번호 입력
        for (int i = 0; i < N; i++) {
            studentNum[i][0] = i + 1;
            for (int j = 1; j < 6; j++) {
                studentNum[i][j] = in.nextInt();
            }
        }

        // 같은 반이었다면 [i][6]++, [k][6]++
        // 이미 같은 반을 한 적이 있다면 true
        for (int j = 1; j < 6; j++) {
            for (int i = 0; i < N - 1; i++) {
                for (int k = i+1; k < N; k++) {
                    if ((studentNum[i][j] == studentNum[k][j]) && !alreadyChecked[i][k]) {
                        studentNum[i][6]++;
                        studentNum[k][6]++;
                        alreadyChecked[i][k]=true;
                    }
                }
            }
        }

        int max = 0;
        int result = 1;
        for (int i = 0; i < N; i++) {
                if(max<studentNum[i][6]) {
                    max = studentNum[i][6];
                    result = i+1;
            }
        }
        System.out.println(result);
    }
}
