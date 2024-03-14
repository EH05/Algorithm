package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q10817_세수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] num = new int[3];

        for(int i=0; i<3; i++) {
            num[i] = in.nextInt();
        }

        Arrays.sort(num);

        System.out.println(num[1]);
    }
}
