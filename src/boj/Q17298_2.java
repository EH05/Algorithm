package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q17298_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            stack.add(in.nextInt());
        }

        int result = stack.pop();
        int max = result;
        sb.append(-1);
        sb.append(' ');

        int storage = 0;

        while(!(stack.isEmpty())) {
            // 바로 다음에 작은게 온다면
            if(result>stack.peek()) {
                if(storage>stack.peek()){
                    result = storage;
                    sb.append(result);
                    sb.append(' ');
                    storage = stack.pop();
                } else {
                    sb.append(result);
                    sb.append(' ');
                    storage = stack.pop();
                }
                // 바로 다음에 큰게 온다면
            } else if(result<stack.peek()) {
                    if(max<stack.peek()){
                        sb.append(-1);
                        sb.append(' ');
                        result = stack.pop();
                        max = result;
                    } else if(max>stack.peek()) {
                        sb.append(max);
                        sb.append(' ');
                        result = storage;
                        storage = stack.pop();
                    }
            }
        }

        sb.reverse();

        System.out.println(sb);

    }
}

