package boj;

import java.util.Scanner;

public class Q2669_직사각형네개의합집합의면적구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean[][] map = new boolean[101][101];

        for(int square=0; square<4; square++){
            int start_X = in.nextInt();
            int start_Y = in.nextInt();
            int end_X = in.nextInt();
            int end_Y = in.nextInt();

            for(int r=start_X; r<end_X; r++){
                for(int c=start_Y; c<end_Y; c++){
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
