package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q10828_스택 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            String value = in.next();

            switch (value) {
                case "push" :
                    stack.push(in.nextInt());
                    break;
                case "pop" :
                    sb.append(stack.isEmpty() ? -1: stack.pop()).append('\n');
                    break;
                case "size" :
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty" :
                    sb.append(stack.isEmpty() ? 1: 0).append('\n');
                    break;
                case "top" :
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
                    break;
            }
        }

        System.out.println(sb);

    }
}
