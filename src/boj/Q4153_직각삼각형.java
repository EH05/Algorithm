package boj;

import java.util.Scanner;

public class Q4153_직각삼각형 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[3];

        while (true) {
            for (int i = 0; i < 3; i++) {
                arr[i] = in.nextInt();
            }

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }

            for (int i = 1; i < 3; i++) {
                int max = arr[0];
                if (max < arr[i]) {
                    arr[0]=arr[i];
                    arr[i]=max;
                }
            }

            int num = (arr[1] * arr[1]) + (arr[2]*arr[2]);

            if ((arr[0] * arr[0]) == num) {
                System.out.println("right");
            } else if ((arr[0] * arr[0]) != num) {
                System.out.println("wrong");
            }
        }
    }
}
