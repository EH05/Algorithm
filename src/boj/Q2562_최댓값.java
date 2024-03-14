package boj;

import java.util.Scanner;

public class Q2562_최댓값 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int f=in.nextInt();
        int num=1;

        for(int i=1;i<9;i++) {
            int next=in.nextInt();
            if(next>f) {
                f=next;
                num=i+1;
            }
        }

        System.out.println(f);
        System.out.println(num);
    }
}
