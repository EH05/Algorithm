package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q1918_후위표기식 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        // 알파벳은 바로 stringbuilder에 담는다.
        // 연산자중 *와 /를 우선 추가. +와 -는 나중에 추가



        String cal = in.next();
        for(int i=0; i<cal.length(); i++) {
            char c = cal.charAt(i);
            switch (c) {

                // (일 경우 스택에 push
                case '(' :
                    stack.push(c);
                    break;

                // ) 일 경우 (를 만날때 까지 스택의 연산자를 pop하여 sb에 추가
                case ')' :
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop(); // ( 제거
                    break;

                // * 또는 /일 경우 이미 stack에 들어간 *와 /을 sb에 추가한 후, 본인(* 또는 /)을 추가
                case '*' :
                case '/' :
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        sb.append(stack.pop());
;                    }
                    stack.push(c);
                    break;

                // + 또는 -일 경우 (을 만날때까지 스택의 연산자를 pop하여 sb에 추가한 후, 본인(+ 또는 -)을 추가
                case '+' :
                case '-' :
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;

                // 이게 알파벳의 경우, 바로 sb에 추가
                default:
                    sb.append(c);
                    break;
            }
        }

        // 반복문을 다 돌았는데 남은 연산자가 있다면 모두 출력
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
