package boj;

import java.util.Scanner;

public class Q10952 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            int A= in.nextInt();
            int B= in.nextInt();
            int sum=A+B;

            if(sum==0) {break;}
            System.out.println(sum);

        }
    }
}
