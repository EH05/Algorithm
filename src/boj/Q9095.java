package boj;

import java.util.Scanner;

public class Q9095 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[11];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i=4; i<=10; i++){
            arr[i] = arr[i-3]+ arr[i-2]+arr[i-1];
        }


        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            System.out.println(arr[n]);
        }
    }

}
