package boj;

import java.util.Scanner;

public class Q10994_2_별찍기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int length = 4*N-3; // 사각형의 길이

        // 출력값을 StringBuilder 배열로 생성후, 빈칸으로 다 초기화하기
        StringBuilder[] arr = new StringBuilder[length];
        for(int i=0; i<length; i++){
            arr[i] = new StringBuilder();
        }
        for(int i=0; i<length;i++){
            for(int j=0; j<length; j++){
                arr[i].append(' ');
            }
        }

        for(int start = 0, end=length-1; start<=end; start+=2, end-=2){
            for(int i=start; i<=end; i++){
                for(int j=start; j<=end; j++){
                    if(i == start || i ==end || j == start || j== end){
                        arr[i].setCharAt(j, '*');
                    }
                }
            }
        }

        for(int i=0; i<length; i++){
            System.out.println(arr[i]);
        }

    }
}
