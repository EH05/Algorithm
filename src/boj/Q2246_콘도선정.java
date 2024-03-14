package boj;

import java.util.Scanner;

public class Q2246_콘도선정 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 콘도의 개수

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = in.nextInt(); // 거리
            arr[i][1] = in.nextInt(); // 숙박비
        }
        int count = 0;
        for(int i=0; i<N; i++) {
            boolean isRule = true;

            for(int j=0; j<N; j++) {
                if(arr[i][0]>arr[j][0]) {
                    if(arr[i][1]>=arr[j][1]){
                        isRule = false;
                        break;
                    }
                }
                if(arr[i][1]>arr[j][1]){
                    if(arr[i][0]>=arr[j][0]){
                        isRule = false;
                        break;
                    }
                }
            }

            if(isRule) {
                count++;
            }
        }


        System.out.println(count);
        }
    }
