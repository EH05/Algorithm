package boj;

import java.util.Scanner;

public class Q1439_뒤집기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String text = in.next();

        int a = 0;
        int b = 0;
        boolean ischange = true;

        int num = text.charAt(0)-'0';

        for(int i=1; i<text.length();i++) {
            if (text.charAt(i)-'0' != num) {
                if (ischange) {
//                    System.out.println(i+"번째, "+text.charAt(i)+"일때, b값이 올라갑니다. ");
                    num = text.charAt(i)-'0';
                    if(a==0 && b==0){
                        a++;
                    }
                    b++;
//                    System.out.println("b="+b);
                    ischange = !ischange;
                } else if (!ischange) {
//                    System.out.println(i+"번째, "+text.charAt(i)+"일때, a값이 올라갑니다. ");
                    num = text.charAt(i)-'0';
                    if(a==0 && b==0){
                        b++;
                    }
                    a++;
//                    System.out.println("a="+a);
                    ischange = !ischange;
                }
            }

        }

        System.out.println(Math.min(a,b));
    }
}
