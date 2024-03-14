package boj;

import java.util.Scanner;

public class Q9663_NQueen {

    static int[] arr; // 1차원배열의 index가 열, 원소값이 행
    static int N;
    static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        arr= new int[N];

        getCount(0);

        System.out.println(count);


    }


    public static void getCount(int depth) {

        // 행을 다 채우면 count++후 return;
        if(depth == N){
            count++;
            return;
        }


        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            // 해당 열에서 i번째 행에 놓을 수 있는지 검사
            // 인덱스 값이 행이다. 즉, 동일한 인덱스 값을 가지는지 검사
            if(check(depth)){
                getCount(depth+1);
            }
        }
    }


    // 같은 열과 대각선에 퀸이 있는지 판별
    // 체스판에 행 부분에 한 개의 값만 들어가게 됨.
    public static boolean check(int col){
        for(int i=0; i<col; i++){
            // 해당 열의 행과 i열의 행이 일치할 경우 (같은 행에 존재할 경우)
            if(arr[col] == arr[i]){
                return false;
            }

            // 대각선상에 놓여있는 경우
            // (열의 차와 행의 차가 같은 경우)
            else if(Math.abs(col - i) == Math.abs(arr[col]-arr[i])){
                return false;
            }
        }
        return true;
    }
}

