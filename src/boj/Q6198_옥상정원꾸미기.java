package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q6198_옥상정원꾸미기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 빌딩의 개수

        // stack을 사용하여 빌딩의 높이를 저장하고,
        // 각 빌딩이 다른 빌딩들에게 가리지 않는 경우의 수 계싼
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        stack.push(in.nextInt()); // 첫 번째 빌딩의 높이를 스택에 추가

        for (int i = 1; i < N; i++) {
            int compare = in.nextInt(); // 현재 빌딩의 높이

            // 현재 빌딩의 높이가 stack의 top보다 큰 경우,
            // stack에서 작은 높이의 빌딩들을 모두 제거
            while (!stack.isEmpty() && stack.peek() <= compare) {
                stack.pop();
            }

            // 현재 빌딩이 자신보다 큰 빌딩이 나타난 횟수를 누적하여 sum에 추가
            sum += stack.size();
            stack.push(compare);
        }

        System.out.println(sum);
    }
}

