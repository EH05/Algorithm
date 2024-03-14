package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 명령의 수

        Deque<Integer> dq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열을 구분자를 이용하여 분리할 때, StringTokenizer 사용
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_back" :
                    int k = Integer.parseInt(st.nextToken());
                    dq.addLast(k);
                    break;
                case "push_front" :
                    int p = Integer.parseInt(st.nextToken());
                    dq.addFirst(p);
                    break;
                case "pop_front" :
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.pollFirst()).append('\n');
                    break;
                case "pop_back" :
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.pollLast()).append('\n');
                    break;
                case "front" :
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.peekFirst()).append('\n');
                    break;
                case "back" :
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.peekLast()).append('\n');
                    break;
                case "size" :
                    sb.append(dq.size()).append('\n');
                    break;
                case "empty" :
                    if (dq.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
