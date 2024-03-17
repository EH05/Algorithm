package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 스크린 N칸
        int M = Integer.parseInt(st.nextToken()); // 스크린 M칸

        int J = Integer.parseInt(br.readLine()); // 사과의 개수

        int moveLength = 0;

        int startSpot = 1;
        int endSpot = M;

        for (int count = 1; count <= J; count++) {
            int spot = Integer.parseInt(br.readLine()); // 사과가 떨어지는 위치
            if (startSpot <= spot && spot <= endSpot) continue;
            else if (endSpot < spot) {
                moveLength += spot - endSpot;
                startSpot = spot - M + 1;
                endSpot = spot;
            } else if (startSpot > spot) {
                moveLength += startSpot - spot;
                startSpot = spot;
                endSpot = spot + M - 1;
            }
        }

        System.out.println(moveLength);


    }
}
