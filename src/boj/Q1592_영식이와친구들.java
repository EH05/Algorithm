package boj;

import java.util.Scanner;

public class Q1592_영식이와친구들 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // N명의 친구들
        int M = in.nextInt(); // M번 받으면 끝남.
        int L = in.nextInt(); // L번째 사람에게 공을 던짐.

        int[] arr = new int[N + 1];
        int count = 0;
        int i = 1;


        while (true) {
            arr[i]++;
            if (arr[i] == M) {
                break;
            }
            if (arr[i] % 2 != 0) {
                i += L;
                if (i > N) {
                    i = i - N;
                }
            } else {
                i -= L;
                if (i <= 0) {
                    i += N;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}