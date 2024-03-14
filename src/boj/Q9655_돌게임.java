package boj;

import java.util.Scanner;

public class Q9655_돌게임 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 돌의 갯수

        int turn = 0; // 돌을 가져가는 사람 (홀수면 상근, 짝수면 창영)

        // N이 0보다 클때까지 진행
        while (N > 0) {
            if(N>=3) {   // N이 3이상이면
                N-=3;    // N은 -3
                turn++;
            } else if(N<3){  // N이 3이하이면
                N-=1;        // N은 -1
                turn++;
            }
        }

        if(turn%2==0) {
            System.out.println("CY");
        } else System.out.println("SK");
    }
}
