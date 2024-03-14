package boj;

import java.util.Scanner;

public class Q3052_나머지 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[10];
        int result = 0;

        for (int i = 0; i < 10; i++) {
            int num = in.nextInt();
            arr[i] = num % 42;
        }

        for (int i = 0; i < 10; i++) {
            boolean isFalse = false;

            for (int j = i + 1; j < 10; j++) {
                if(arr[i]==arr[j]) {
                    isFalse = true;
                    break;
                }
            }

            if(isFalse==false) {
                result ++;
            }
        }

        System.out.println(result);
    }
}
