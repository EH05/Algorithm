package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7682 {
    static char[][] bingo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String order = br.readLine();
            if (order.equals("end")) break;
            bingo = new char[3][3];

            int idx = 0;

            int x = 0;
            int o = 0;
            int dot = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bingo[i][j] = order.charAt(idx++);
                    if (bingo[i][j] == 'O') o++;
                    else if (bingo[i][j] == 'X') x++;
                    else if (bingo[i][j] == '.') dot++;

                }
            }

            // x >= o 이어야함.

            // x > o 인 경우
            // x가 o보다 1만 많아야함.
            if (x == o+1) {
                // 이건 x가 이긴 경우
                if (!check('O') && check('X')) {
                    sb.append("valid").append("\n");
                    // 이건 칸이 다채워졌는데 둘다 빙고가 없을 경우
                } else if(dot==0 && !check('O') && !check('X')){
                    sb.append("valid").append("\n");
                } else {
                    sb.append("invalid").append("\n");
                }
                // x==o인 경우 (o가 이김)
            } else if (x == o) {
                // o만 빙고여야함.
                if (!check('X') && check('O')) {
                    sb.append("valid").append("\n");
                } else {
                    sb.append("invalid").append("\n");
                }
            } else {
                sb.append("invalid").append("\n");
            }
        }

        System.out.println(sb);

    }

    public static boolean check(char c) {

        // 가로 확인
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (bingo[i][j] == c) cnt++;
            }
            if (cnt == 3) return true;
        }
        //세로 확인
        for (int j = 0; j < 3; j++) {
            int cnt = 0;
            for (int i = 0; i < 3; i++) {
                if (bingo[i][j] == c) cnt++;
            }
            if (cnt == 3) return true;
        }
        //대각선 확인
        if (bingo[0][0] == c && bingo[1][1] == c && bingo[2][2] == c) return true;
        if (bingo[0][2] == c && bingo[1][1] == c && bingo[2][0] == c) return true;

        return false;
    }
}
