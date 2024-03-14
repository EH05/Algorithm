package boj;

import java.util.Scanner;

public class Q10813 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] basket = new int[N];
        int M = in.nextInt();

        for (int i = 0; i < N; i++) {
            basket[i] = i + 1;
        }

        for (int f = 0; f < M; f++) {
            int i=in.nextInt();
            int j=in.nextInt();

            int temp=basket[i-1];
            basket[i-1]=basket[j-1];
            basket[j-1]=temp;
        }

        for(int g=0;g<N;g++) {
            System.out.print(basket[g]+" ");
        }
    }
}
