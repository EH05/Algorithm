package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q17298 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();

        int N = in.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = in.nextInt();
        }


        // 스택이 비어있지않으면서 && 현재 원소가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
        // Stack의 원소를 pop하면서 해당 인덱스의 값을 현재 원소로 바꿈
        for(int i=0; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);

        }

        // stack의 모든 원소를 pop 하면서 해당 인덱스의 값을 -1로 초기화
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }




        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);

    }
}

