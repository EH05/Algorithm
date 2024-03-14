package boj;

import java.util.Scanner;

public class Q5543_상근날드 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int price = 2100;

        for(int i=0; i<3; i++) {
            int burger = in.nextInt();
            if(price>burger) {
                price=burger;
            }
        }

        int coke = in.nextInt();
        int soda = in.nextInt();
        if(coke>=soda) {
            price+=soda;
        } else if(coke<soda) {
            price+=coke;
        }

        System.out.println(price-50);

    }
}
