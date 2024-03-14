package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1759 {
    static String[] arr;
    static String[] result;

    static int L;
    static int C;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        L = in.nextInt(); // 암호의 개수
        C = in.nextInt(); // 주어진 문자의 개수

        arr = new String[C];
        result = new String[L];

        for (int i = 0; i < C; i++) {
            arr[i] = in.next();
        }

        Arrays.sort(arr);

        findResult(0, 0);
    }

    static void findResult(int startIdx, int num) {
        System.out.println("startidx와 num은 "+startIdx+"입니다.");

        if (num == L) {
            System.out.println("num은 "+L+"입니다.");

            int a = 0;
            int b = 0;

            for (int i = 0; i < L; i++) {
                if (result[i].equals("a") || result[i].equals("e") || result[i].equals("i") || result[i].equals("o") || result[i].equals("u")) {
                    a++;
                } else b++;
            }

            if (a >= 1 && b >= 2) {
                for (int i = 0; i < L; i++) {
                    System.out.print(result[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = startIdx; i < C; i++) {
            result[num] = arr[i];
            findResult(i + 1, num + 1);
        }
    }
}
