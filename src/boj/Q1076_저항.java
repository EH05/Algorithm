package boj;

import java.util.Scanner;

public class Q1076_저항 {
    public static void search(String a, String b, String c){
        String color[] = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        while (true) {

            if (a.equals(color[0]) && b.equals(color[0])) {
                System.out.print(0);
                break;
            }

            for (int i = 1; i < color.length; i++) {
                if (a.equals(color[i])) {
                    System.out.print(i);
                }
            }

            for (int j =0; j < color.length; j++) {
                if (b.equals(color[j])) {
                    System.out.print(j);
                }
            }

            for (int k = 0; k < color.length; k++) {
                if (c.equals(color[k])) {
                    for (int s = 0; s < k; s++) {
                        System.out.print(0);
                    }
                }
            }

            break;
        }



    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        String c = in.next();

        search(a,b,c);
    }
}
