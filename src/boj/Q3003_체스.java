package boj;

import java.util.Scanner;

public class Q3003_체스 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] Chess = {1, 1, 2, 2, 2, 8};
        int[] check = new int[6];

        for (int i = 0; i < 6; i++) {
            int num = in.nextInt();
            check[i] = Chess[i]-num;
        }

        for(int j=0; j<6; j++) {
            System.out.print(check[j]+" ");
        }
    }
}
