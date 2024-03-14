package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q10799_쇠막대기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); // 이전값을 확인하기 위한 용도


        // (()) 일때
        // ( 은 바로 stack과 sb에 넣기
        // ) 은 이전 값을 확인하였을때(sb로 확인)
        // 이전 값이 ( 이면 (즉, ()이여서 레이저가 되면), 쇠막대기의 수는 stack의 길이
        // 이전 랎이 ) 이면 (즉, ))이여서 쇠막대기였다면), 쇠막대기는 +1만 됨.


        String bar = in.next();


        int cnt = 0; // 잘린 쇠막대기의 수

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<bar.length(); i++) {
            char value = bar.charAt(i);

            // ( 라면 stack과 sb에 삽입
            if(value == '(') {
                sb.append(value);
                stack.push(value);

            }

            // ) 라면 이전 값 확인
            else if(value == ')') {

                // 이전 값이 ( 라면 stack에서 pop, cnt=stack의 사이즈
                if(sb.charAt(i-1)=='(') {
                    sb.append(value);
                    stack.pop();
                    cnt+=stack.size();
                }

                // 이전 값이 ) 라면 stack에서 pop, cnt++
                else if(sb.charAt(i-1)==')') {
                    sb.append(value);
                    stack.pop();
                    cnt++;
                }
            }
        }

        System.out.println(cnt);


    }
}
