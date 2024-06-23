package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result = arr[N-1];
        int num = 1;

        for(int i=N-2; i>=0; i--){
            num++;
            if(arr[i]*num>result){
                result = arr[i]*num;
            }
        }
        System.out.println(result);
    }
}
