package boj;

import java.util.Scanner;

public class Q10994_별찍기 {

    static char result[][];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        N = 4*N-3; // 가로 세로의 길이
        result = new char[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result[i][j] = ' ';
            }
        }

        findresult(0,N);

        printresult(N);


    }

    public static void findresult(int first, int last){
        if(last<=first) return;

        for(int i=first; i<last; i++){
            result[first][i] = '*'; // 맨처음 가로
            result[last-1][i] = '*'; // 맨 마지막 가로
            result[i][first] = '*'; // 왼쪽 세로
            result[i][last-1] = '*'; // 오른쪽 세로
        }

        findresult(first+2, last-2);

    }

    public static void printresult(int N){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
