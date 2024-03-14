package boj;

import java.util.Scanner;

public class Q2501_약수구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int arr[] = new int[N];
        int index=0;

        for(int i=1; i<=N; i++) {
            if(N%i==0) {
                arr[index]=i;
                index++;
            }
        }

        int d = (index>=K) ? arr[K-1] : 0;
        System.out.println(d);

    }
}
