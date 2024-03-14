package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q5430 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        TC:
        for (int tc = 0; tc < T; tc++) {

            // 조건 받기
            String method = in.next();
            int N = in.nextInt();


            StringTokenizer st = new StringTokenizer(in.next(), "[],");

            // que에 배열 집어넣기
            LinkedList<Integer> que = new LinkedList<>();
            for(int i=0; i<N; i++){
                que.offer(Integer.parseInt(st.nextToken()));
            }

            // 함수별로 실행
            for (int i = 0; i < method.length(); i++) {
                switch (method.charAt(i)) {
                    case 'R':
                        R(que);
                        break;
                    case 'D':
                        if (que.isEmpty()) {
                            System.out.println("error");
                            continue TC;
                        }
                        D(que);
                        break;
                }
            }

            System.out.println(que);
        }
    }

    // 뒤집는 함수
    public static void R(LinkedList<Integer> que){
        boolean isRight = true;


    }

    // 삭제하는 함수
    public static void D(LinkedList<Integer> que){
        que.pollFirst();
    }
}
