package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N자리 숫자
        int K = Integer.parseInt(st.nextToken()); // K개의 숫자 삭제

        String value = br.readLine();

        stack.add(value.charAt(0) - '0');

        int count = 0;

        for (int i = 1; i < N; i++) {
            int num = value.charAt(i) - '0';


            // stack에서 num보다 작은애들은 다 빼기
            while (!stack.isEmpty() && stack.peekLast() < num && count < K) {
                stack.pollLast();
                count++;
            }
            stack.add(num);
        }

        // 테케 2 1 22
        while(count<K && !stack.isEmpty()){
            stack.pollLast();
            count++;
        }

        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }

        System.out.println(sb);

    }
}
