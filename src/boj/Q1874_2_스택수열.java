package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q1874_2_스택수열 {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean isOK = false;

        int n = in.nextInt();

        int first = 0;

        for(int tc = 0; tc<n; tc++) {

            int num = in.nextInt();

            // 해당 num까지 first++하며 stack에 push
            if (num > first) {
                for (int i = first + 1; i <= num; i++) {
                    s.push(i);
                    sb.append("+\n");
                }
                first = num;
                // s.peek()이 num과 다르다는건 s.peek이 num보다 클 경우임.
            } else if (s.peek() != num) {
                System.out.println("NO");
                isOK = true;
                break;
            }

            // 꼭대기에 있는 원소가 주어진 수와 같다면
            // 꼭대기에 있는 원소는 무조건 뺀다.
            s.pop();
            sb.append("-\n");
        }

        if(!isOK) {
            System.out.println(sb);
        }
    }
}