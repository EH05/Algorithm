package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q2841_외계인의기타연주 {

    public static void main(String[] args) {

        Stack<Integer>[] stack;

        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // N개의 줄
        int P = in.nextInt(); // P개의 플랫

        stack = new Stack[N+1]; // 각 줄에 대한 플랫을 저장하기 위한 스택 배열

        int finger = 0; // 손가락 사용 횟수

        for(int i =0; i<=N; i++) {
            stack[i] = new Stack<>();
        }

        for(int i=0; i<N; i++) {
            int line = in.nextInt();
            int flat = in.nextInt();

            // 스택이 비어있는 경우
            // 새로운 손가락을 사용하고 현재 누르려는 플랫을 스택에 추가.
            if(stack[line].size() == 0) {
                finger++;
                stack[line].push(flat);
                continue;
            }

            // 스택의 맨 위에 있는 플랫이 현재 누르려는 플랫보다 큰 경우
            // 스택에서 플랫을 빼내고 손가락을 한번 더 사용
            while(stack[line].peek() > flat) {
                finger++;
                stack[line].pop();
                if(stack[line].size() == 0)
                    break;
            }

            // 누르려고하는 플랫과 이미 그 줄에 눌려있는 플랫의 번호가 같은 경우
            if(stack[line].size() != 0 && stack[line].peek() == flat)
                continue;

            // 스택의 맨 위 플랫이 현재 누르려는 플랫보다 작은 경우,
            // 새로운 손가락을 사용하고 현재 누르려는 플랫을 스택에 추가.
            finger++;
            stack[line].push(flat);

        }

        System.out.println(finger);

    }
}