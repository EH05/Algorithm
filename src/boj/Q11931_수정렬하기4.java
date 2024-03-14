package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q11931_수정렬하기4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        for(int i=N-1; i>=0; i--){
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }
}
