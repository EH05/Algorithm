package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q1847_스택수열 {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean isOK = false;


        int n = in.nextInt();

        int first = 0;

        for(int tc = 0; tc<n; tc++){

            int num = in.nextInt();

            // 주어진 수가 first 값보다 크다면
            // 만약 first 값이 0일때, num이 4라면 진행
            if (num > first) {
                for (int i = first + 1; i <= num; i++) {
                    s.push(i);  // 해당 정수까지 stack에 push.
                    sb.append('+').append('\n');
                }
                first = num; // 지금까지 push 한 수로 변수 초기화
                // (다음에는 first+1 값 부터 push 됨)
            }


            // 주어진 수가 first보다 크지 않을때 진행되어야함. (else if 사용)
            else if (s.peek() != num) {
                System.out.println("NO");
                isOK = true;
                break;
            }

            // 꼭대기에 있는 원소가 주어진 수와 같다면
            // 꼭대기에 있는 원소는 무조건 뺀다.
            s.pop();
            sb.append('-').append('\n');
        }

        if(!isOK) {
            System.out.println(sb);
        }
    }
}
