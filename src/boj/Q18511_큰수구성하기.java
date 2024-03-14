package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q18511_큰수구성하기 {

    static int[] arr;
    static int result=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // N보다 작거나 같은 자연수
        int K = in.nextInt(); // K개의 원소로만 구성된

        arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        findresult(N,0);
        System.out.println(result);
    }

    public static void findresult(int N, int num){
        System.out.println();
        System.out.println("N= "+N+", num= "+num);

        if(num>N) {
            System.out.println("num이 N보다 커서 돌아갑니다.");
            return;
        }

        if(result < num){
            result = num;
            System.out.println("result는 num으로 초기화됩니다. result= "+result);
        }


        for(int i=arr.length-1; i>=0; i--){
            System.out.println("배열중 다음수를 불러옵니다. i="+ i+", arr[i]="+arr[i]);
           findresult(N, num*10+arr[i]);
        }

    }
}
