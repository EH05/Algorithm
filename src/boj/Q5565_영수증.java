package boj;

import java.util.Scanner;

public class Q5565_영수증 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int total_price = in.nextInt();

        for (int i = 0; i < 9; i++) {
            int price = in.nextInt();

            total_price -= price;
        }

        System.out.println(total_price);
    }
}
