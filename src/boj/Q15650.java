package boj;

import java.util.Scanner;

public class Q15650 {
    static int[] arr;
    static int[] sel;

    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt(); // N까지 자연수
        M = in.nextInt(); // M개 고름

        arr = new int[N];
        sel = new int[M];

        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        combination(0,0);

    }

    public static void combination(int idx, int sidx){
        if(sidx==M){
            for(int i=0; i<M; i++){
                System.out.print(sel[i]+" ");
            }
            System.out.println();
        } else if(idx >= N) return;
        else {
            sel[sidx] = arr[idx];
            combination(idx+1,sidx+1);
            combination(idx+1, sidx);
        }
    }
}
