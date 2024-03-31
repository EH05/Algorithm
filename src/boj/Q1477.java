package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 현재 휴게소의 개수
        int M = Integer.parseInt(st.nextToken()); // 더 지으려고 하는 휴게소의 개수
        int L = Integer.parseInt(st.nextToken()); // 고속도로의 길이

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 2]; // 주어지지 않는 고속도록 맨앞과 맨뒤도 넣어야함.
        arr[0] = 0;
        arr[N + 1] = L;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = L - 1;

        while (left <= right) {
            int mid = (left + right) / 2; // mid 길이만큼의 거리에 휴게소를 세운다면 몇개의 휴게소가 필요한지 계산
            System.out.println("left="+left+", right="+right+", mid="+mid);
            int count = 0;

            for (int i = 1; i < N + 2; i++) {
                count += (arr[i] - arr[i - 1] - 1) / mid;
                System.out.println("i가 "+i+", count="+count);
            }
            if (count > M) left = mid + 1;
            else right = mid - 1;

        }

        System.out.println(left);

    }
}
