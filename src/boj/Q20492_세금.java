package boj;

import java.util.Scanner;

public class Q20492_세금 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int A = (int) (N*0.78);
        int B = (int) ((int) (N*0.8)+(N*0.2*0.78));

        System.out.println(A+" "+B);


    }
}
