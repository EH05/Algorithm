package boj;

import java.util.Scanner;

public class Q10872_팩토리얼 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int result = recursion(in.nextInt());

        System.out.println(result);
    }


    public static int recursion(int a){
        if (a<=1){
            return 1;
        }
        return a*recursion(a-1);
    }
}
