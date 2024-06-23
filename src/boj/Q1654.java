package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        // 이분 탐색
        // 인덱스가 아닌 랜선의 길이 찾기 (목표 개수에 대한 길이 찾기) => 정렬X

        int[] arr = new int[K];

        long maxLen = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxLen = Math.max(maxLen, arr[i]);
        }

        maxLen++; // 최대 길이+1이

        long minLen = 0;
        long mid = 0;

        while (minLen < maxLen) {
            System.out.println("---------------");

            mid = (maxLen + minLen) / 2;


            long count = 0; // 랜선의 개수

            // 중간 길이로 잘랐을때 총 몇 개가 만들어지는지
            for (int i = 0; i < K; i++) {
                count += (arr[i] / mid);
            }


            // count가 목표 개수보다 적으면
            // 더 작게 잘라야한다는 것
            // 최대 길이를 중간길이로 재정의
            if (count < N) {
                maxLen = mid;
                // mid 길이로 목표 개수를 만들 수 있다는 거니까
                // 최소길이를 중간길이+1로 재정의
                // 이미 N개를 만들 수 있는 최소 길이는 찾았으니까
                // 길이를 더 늘려가면서 최대 랜선 길이를 찾는거다.
            } else {
                minLen = mid + 1;
            }
            System.out.println("maxLen="+maxLen);
            System.out.println("mid="+mid);
            System.out.println("minLen="+minLen);
            System.out.println("count="+count);
        }


        System.out.println(maxLen-1);

    }
}
