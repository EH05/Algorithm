package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15666 {

    static List<Integer> list;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N개의 자연수
        int M = Integer.parseInt(st.nextToken()); // 길이가 M인 수열

        result = new int[M];

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        list = new ArrayList<>(set);
        Collections.sort(list);

        getResult(0, M);

        System.out.println(sb);

    }

    public static void getResult(int idx, int M) {
        if (idx == M) {
            for(int i: result){
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (idx > 0 && result[idx - 1] > list.get(i)) continue;
            result[idx] = list.get(i);

            getResult(idx + 1, M);
        }
    }
}
