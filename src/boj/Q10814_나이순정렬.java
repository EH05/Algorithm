package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q10814_나이순정렬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();

        String[][] arr = new String[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = in.next();
            arr[i][1] = in.next();

        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
            }
        });


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}