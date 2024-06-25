package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken()); // 사탕의 개수
            int N = Integer.parseInt(st.nextToken()); // 상자의 개수

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.add(r * c);
            }

            Collections.sort(list, Collections.reverseOrder());

            int box = 0;
            for (int size : list) {
                J -= size;
                box++;

                if(J<=0) break;
            }

            sb.append(box).append("\n");


        }

        System.out.println(sb);

    }
}
