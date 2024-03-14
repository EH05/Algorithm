package boj;

import java.util.Scanner;

public class Q1568_새 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 새의 수

        int k = 1; // 숫자 K
        int sec = 0; // 소요된 시간

        // 새가 0마리보다 많을때까지 while문 실행
        // 0마리보다 많을때, 새보다 숫자K가 크다면 숫자는 1로 초기화
        // 그렇지 않으면 시간과 숫자는 증가함.
        while (N>0) {
            if(k>N) {
                k=1;
            } else {
                sec++;
                N-=k;
                k++;
            }
        }

        System.out.println(sec); // 소요된 시간 출력

    }
}
