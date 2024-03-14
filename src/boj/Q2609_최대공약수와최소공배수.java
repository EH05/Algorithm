package boj;

import java.util.Scanner;

public class Q2609_최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int mul = a*b;

        if(b<a) {
            int temp = a;
            a=b;
            b=temp;
        }

        while (b!= 0) {
            a=a%b;
            int r = a;
            a=b;
            b=r;
        }

        System.out.println(a);
        System.out.println(mul/a);
    }
}
