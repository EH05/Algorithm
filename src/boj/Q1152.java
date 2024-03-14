package boj;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1152 {
    public static void main(String[] args) {
        String inputString = "1,2,3,4,5";
        Scanner in = new Scanner(inputString);

        int count = 0;
        String str = in.nextLine();
        System.out.println("str = " + str);
        StringTokenizer st = new StringTokenizer(str, ",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }
}
