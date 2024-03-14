package boj;

import java.util.Scanner;

public class Q2490_윷놀이 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int num = in.nextInt();
                sum += num;
            }
            switch (sum) {
                case 1 :
                    System.out.println("C");
                    break;
                case 2 :
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("A");
                    break;
                case 4 :
                    System.out.println("E");
                    break;
                case 0 :
                    System.out.println("D");
                    break;
            }
        }
    }
}
