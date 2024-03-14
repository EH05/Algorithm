package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q10773_제로 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int K = in.nextInt(); // K개의 줄

        Stack<Integer> stackInt = new Stack<>(); // 스택 선언

        for(int i=0; i<K; i++) {
            int num = in.nextInt();

            if(num==0) {
                stackInt.pop();
            }
            else {
                stackInt.push(num);
            }
        }

        int sum = 0;
        for(int j : stackInt) {
            sum += j;
        }

        System.out.println(sum);


    }
}
