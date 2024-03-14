package boj;

import java.util.Scanner;

public class Q2563_색종이 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean[][] map = new boolean[101][101];

        int T = in.nextInt();
        for(int square=0; square<T; square++){
            int start_X = in.nextInt();
            int start_Y = in.nextInt();

            for(int r=start_X; r<start_X+10; r++){
                for(int c=start_Y; c<start_Y+10; c++){
                    map[r][c] = true;
                }
            }
        }

        int count = 0;

        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                if(map[i][j]) count++;
            }
        }

        System.out.println(count);
    }
}
