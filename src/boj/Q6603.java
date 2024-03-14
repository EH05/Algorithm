package boj;

import java.util.Scanner;

public class Q6603 {
    static int k;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            k = in.nextInt();
            if (k == 0) break;

            arr = new int[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                arr[i] = in.nextInt();
            }

            findResult(0, 0);

            System.out.println();


        }
    }

    static void findResult(int startIdx, int num){
        if(num == 6){
            for(int i=0; i<6; i++)
                System.out.print(result[i]+" ");
            System.out.println();
            return;
        }

        for(int i=startIdx; i<k; i++){
            result[num] = arr[i];
            findResult(i+1, num+1);
        }
    }
}
