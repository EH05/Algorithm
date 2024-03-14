package boj;

import java.util.Scanner;

public class Q10156_과자 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int K = in.nextInt(); // 과자 한 개의 가격
        int N = in.nextInt(); // 사려고하는 과자의 개수
        int M = in.nextInt(); // 현재 가진 돈의 액수

        int totalPrice = K*N;

        if(M < totalPrice) {
            System.out.println(totalPrice-M);
        } else if(M>=totalPrice) {
            System.out.println(0);
        }
    }
}
