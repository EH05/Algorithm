package boj;

import java.util.Scanner;

public class Q2738_행렬덧셈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N=in.nextInt();
        int M=in.nextInt();

        int[][] arr1=new int[N][M];
        int[][] arr2=new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M;j++) {
                arr1[i][j]=in.nextInt();
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M;j++) {
                arr2[i][j]=in.nextInt();
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M;j++) {
                System.out.print(arr1[i][j]+arr2[i][j]+" ");
            }
            System.out.println();
        }
    }
}
