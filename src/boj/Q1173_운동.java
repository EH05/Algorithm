package boj;

import java.util.Scanner;

public class Q1173_운동 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 목표 운동 시간
        int m = in.nextInt(); // 초기 맥박
        int M = in.nextInt(); // 최대 맥박
        int T = in.nextInt(); // 운동할때 증가하는 양
        int R = in.nextInt(); // 휴식하면 감소하는 양

        int count = 0;
        int pulse = m;
        int result = 0;

        while (count<N) {
            if (pulse + T <= M) {
                pulse += T;
                count++;
                result++;
            } else if(pulse==m) {
                break;
            } else {
                result++;
                pulse -= R;
                if(pulse<m) {pulse=m;}
            }
        }

        if(N==count) {
            System.out.println(result);
        } else System.out.println(-1);
    }
}