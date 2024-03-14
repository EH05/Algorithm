package boj;

import java.util.Scanner;

public class Q5585_거스름돈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int money = in.nextInt();
        int count = 0;
        int[] moneyArr = {500, 100, 50, 10, 5, 1};
        money = 1000-money;


        for(int i=0; i<6; i++){
            if(money/moneyArr[i]>0){
                count += money/moneyArr[i];
                money = money%moneyArr[i];
            }
        }

        System.out.println(count);

    }
}
