package boj;

import java.util.Scanner;

public class Q10871_X보다작은수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();

        int[] arr = new int[A];
        for (int i = 0; i < A; i++) {
            arr[i] = in.nextInt();
        }


        for (int j = 0; j < A; j++) {
            if (B > arr[j]) {
                System.out.print(arr[j]+" ");
            }
        }
    }
}




