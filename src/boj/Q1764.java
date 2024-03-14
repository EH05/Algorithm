package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> first = new HashSet<>();
        List<String> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수

        for(int i=0; i<N; i++){
            first.add(br.readLine());
        }

        for(int i=0; i<M; i++){
            String person = br.readLine();
            if(first.contains(person)){
                result.add(person);
            }
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(result);

        sb.append(result.size()).append('\n');
        for(String answer:result){
            sb.append(answer).append('\n');
        }

        System.out.println(sb);

    }
}
