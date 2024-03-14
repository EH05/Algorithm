package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q10815_숫자카드 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt(); // 상근이의 숫자 카드의 갯수
        int[] sangCard = new int[N]; // 상근이의 숫자 카드
        for (int i = 0; i < N; i++) {
            sangCard[i] = in.nextInt();
        }

        Arrays.sort(sangCard); // 정렬


        int M = in.nextInt(); // 숫자 카드의 갯수
        int[] Card = new int[M]; // 숫자 카드
        for (int i = 0; i < M; i++) {
            int num = in.nextInt();

            int start = 0;
            int end = N - 1;
            boolean isnotexisted = false;

            // 이분 탐색
            while (start <= end) {
                int mid = (start + end) / 2;
                if (sangCard[mid] == num) {
                    sb.append(1).append(' ');
                    isnotexisted = true; // 존재하면 1출력 break, boolean 변경
                    break;
                }
                if (sangCard[mid] > num) {
                    end = mid - 1;
                } else start = mid + 1;
            }

            if (!isnotexisted) {
                sb.append(0).append(' '); // 존재하지않으면 0 출력
            }

        }

        System.out.println(sb);
    }
}
