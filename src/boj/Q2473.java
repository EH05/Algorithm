package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 전체 용액의 수

        long[] arr = new long[N]; // 용액의 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);


        long min = Long.MAX_VALUE;

        long first = 0;
        long second = 0;
        long third = 0;

        for (int i = 0; i < N - 2; i++) {
            int start = i;
            int mid = i + 1;
            int end = N - 1;
            while (mid < end) {
                long sum = arr[start] + arr[mid] + arr[end];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    first = start;
                    second = mid;
                    third = end;
                }
                if (sum == 0) break;
                else if (sum > 0) end--;
                else mid++;
            }
        }
        System.out.println(arr[(int)first] + " " + arr[(int)second] + " " + arr[(int)third]);

    }
}
