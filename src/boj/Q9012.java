package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for(int i=1; i<=T; i++) {
            String VPS = in.next();
            Stack<Character> stack = new Stack<>();
            boolean isYes = true;
            for(int n = 0; n<VPS.length(); n++) {
                if(VPS.charAt(n)=='(') {
                    stack.add('(');
                } else if(VPS.charAt(n)==')') {
                    if(!(stack.isEmpty()) && stack.peek() != '('){
                        isYes = false;
                        break;
                    } else if (!(stack.isEmpty()) && stack.peek() == '(') {
                        stack.pop();
                    } else if(stack.isEmpty()) {
                        isYes = false;
                        break;
                    }
                }
            }
            if(isYes && stack.isEmpty()){
                System.out.println("YES");
            } else System.out.println("NO");

        }
    }
}
