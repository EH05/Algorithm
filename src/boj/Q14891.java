package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14891 {

    // 0 : N극 // 1 : S극

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 자석 배열 생성 및 초기화
        int[][] arr = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = line.charAt(j)-'0';
            }
        }

        // 명령
        int K = Integer.parseInt(br.readLine());

        // 명령 입력받기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1; // 입력받은 숫자 -1 이 해당 자석의 행임.
            int lr = Integer.parseInt(st.nextToken());

            int[] dir = new int[4];
            dir[row] = lr;

            for (int j = row - 1; j >= 0; j--) {
                if (arr[j][2] == arr[j + 1][6]) break;
                else dir[j] = -dir[j + 1]; // 방향을 반대로 설정
            }

            for (int j = row + 1; j < 4; j++) {
                if (arr[j - 1][2] == arr[j][6]) break;
                else dir[j] = -dir[j - 1];
            }

            for (int j = 0; j < 4; j++) {
                if (dir[j] == 0) continue; // 0: 회전 X
                else if (dir[j] == 1) { // 1 : 시계방향으로 회전
                    // 제일 뒤에걸 따로 뺐다가 배열을 하나씩 뒤로 밀고, temp는 맨 앞으로 온다.
                    int temp = arr[j][7];
                    for (int r = 7; r > 0; r--) {
                        arr[j][r] = arr[j][r - 1];
                    }
                    arr[j][0] = temp;
                } else if (dir[j] == -1) { // -1 : 반시계방향으로 회전
                    // 제일 앞에걸 따로 뺐다가 배열은 하나씩 앞으로 옮기고, temp는 맨 뒤로 간다.
                    int temp = arr[j][0];
                    for (int r = 0; r < 7; r++) {
                        arr[j][r] = arr[j][r + 1];
                    }
                    arr[j][7] = temp;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                result += (int) Math.pow(2, i);
            }
        }

        System.out.println(result);


    }


}

