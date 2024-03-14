package boj;

import java.util.Scanner;

public class Q5524_입실관리 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();

        for(int i=0; i<N;i++){
            String name = in.next();

            sb.append(name.toLowerCase()).append('\n');

        }

        System.out.println(sb);
    }
}
