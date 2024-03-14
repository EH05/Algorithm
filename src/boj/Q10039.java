package boj;

import java.util.Scanner;

public class Q10039 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int result = 0;

        for(int i=0; i<5; i++) {
            int score = in.nextInt();
            if(score<40) {
                score=40;
            }
            result+=score;
        }

        System.out.println(result/5);
    }
}
