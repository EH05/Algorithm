package boj;

import java.util.Scanner;

public class Q10818_버블정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N];
        int temp;
        int count=0;
        int k=1;

        for (int t = 0; t < N; t++) {
            arr[t] = in.nextInt();
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 1; j < N-count; j++) {
                if (arr[i] > arr[count+j]) {
                    temp = arr[i];
                    arr[i] = arr[count+j];
                    arr[count+j] = temp;
                }
            }
            count ++;
        }


        System.out.print(arr[0]+" "+arr[N-1]);



    }
}
