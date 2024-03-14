package boj;

import java.util.Scanner;

public class Q25304_영수증과일치확인 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int X = in.nextInt();
        int N = in.nextInt();
        int[] arr = new int[N];
        int result=0;

        for (int i = 0; i < N; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int sum = a * b;
            arr[i] = sum;
            result += sum;
        }



        if(result==X) {
            System.out.println("Yes");
        }
        else {System.out.println("No");}

    }
}
