package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_Graph_240325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 숫자의 개수 N개
            int K = Integer.parseInt(st.nextToken()); // K번째로 큰 수

            String line = br.readLine();

            Queue<Character> que = new LinkedList<>(); //  수 저장

            for (int i = 0; i < N; i++) {
                que.add(line.charAt(i));
            }

            int len = N / 4;

            TreeSet<Integer> set = new TreeSet<>(); // 결과 저장.

            for (int count = 0; count < len; count++) {
                for (int i = 0; i < 4; i++) {
                    String value = "";
                    for (int j = 0; j < len; j++) {
                        value += que.peek();
                        que.add(que.poll());
                    }
                    set.add(Integer.parseInt(value, 16));
                }
                que.add(que.poll());
            }

            for(int i=0; i<K-1; i++){
                set.pollLast();
            }

            int result = set.pollLast();

            System.out.printf("#%d %d\n",tc,result);
        }
    }
}
