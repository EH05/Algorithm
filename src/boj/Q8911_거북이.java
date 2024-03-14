package boj;

import java.util.Scanner;

public class Q8911_거북이 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int tc = 0; tc < T; tc++) {
            String line = in.next();
            int max_x = 0;
            int min_x = 0;
            int max_y = 0;
            int min_y = 0;

            int x = 0;
            int y = 0;
            int dir = 0;


            int[] dr = {-1, 0, 1, 0}; // 시계방향
            int[] dc = {0, 1, 0, -1};

            for (int i = 0; i < line.length(); i++) {
                char order = line.charAt(i);


                switch (order) {
                    case 'F':
                        x += dr[dir];
                        y += dc[dir];
                        break;
                    case 'B':
                        x -= dr[dir];
                        y -= dc[dir];
                        break;
                    case 'L':
                        if(dir==0) dir=3; // 왼쪽으로
                        else dir--;
                        break;
                    case 'R':
                        if(dir==3) dir=0; // 오른쪽으로
                        else dir++;
                        break;

                }


                max_x = Math.max(max_x,x);
                min_x = Math.min(min_x,x);
                max_y = Math.max(max_y,y);
                min_y = Math.min(min_y,y);


            }

            int X_length = Math.abs(max_x - min_x);
            int Y_length = Math.abs(max_y - min_y);

            System.out.println(X_length * Y_length);
        }

    }

}
