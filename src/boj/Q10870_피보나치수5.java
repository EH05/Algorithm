package boj;

import java.util.Scanner;

public class Q10870_피보나치수5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int result = findresult(N);

        System.out.println(result);
    }

    public static int findresult(int N){

        if(N==0) return N;
        if(N==1) return N;
        return findresult(N-1)+findresult(N-2);
    }
}
