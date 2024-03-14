package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1914_하노이탑 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int A = 1;
        int B = 2;
        int C = 3;

        BigInteger result = new BigInteger("2");
        BigInteger one = new BigInteger("1");

        System.out.println(result.pow(N).subtract(one));

        if(N<=20) {
            hanoi(N, A, B, C);
            System.out.println(sb);
        }



    }

    public static void hanoi(int N, int A, int B, int C){
//        System.out.println("N = "+N+", start "+A+"에서부터 from "+C+"까지 함수 시작합니다.");
        if (N==1){
            sb.append(A).append(' ').append(C).append('\n');
//            System.out.println("N이 1일때 출력 값 =" +sb);
//            System.out.println("N이 1이여서 종료됩니다.");
            return;
        } else {
            hanoi(N-1,A,C,B);
//            System.out.println("N = "+N+", start "+A+"에서부터 from "+B+"까지 함수 끝났습니다.");
            sb.append(A).append(' ').append(C).append('\n');
//            System.out.println(A+"에서 "+C+"로 이동하였습니다.");
//            System.out.println("sb는 ");
//            System.out.println(sb);
            hanoi(N-1,B,A,C);
//            System.out.println("N = "+N+", start "+B+"에서부터 from "+C+"까지 함수 끝났습니다.");
            return;
        }



    }
}