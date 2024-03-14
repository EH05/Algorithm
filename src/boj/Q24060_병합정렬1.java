package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q24060_병합정렬1 {

    static int N; // 배열의 크기
    static int K; // K번째 저장되는 수
    static int[] arr; // 배열
    static int[] sortedArr;
    static int count; // 저장횟수
    static int result=-1;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sortedArr = new int[N];
        count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        mergeSort(0,N-1);

        System.out.println(result);
    }

    static void mergeSort(int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(left,mid);
            mergeSort(mid+1,right);
            merge(left,mid,right);
        }
    }

    static void merge(int left, int mid, int right){
        int L = left;
        int R = mid+1;
        int idx = left;

        while(L <= mid && R <= right){
            if(arr[L]<=arr[R]) {
                sortedArr[idx++] = arr[L++];
                findNum(++count,idx-1);
            }
            else {
                sortedArr[idx++] = arr[R++];
                findNum(++count,idx-1);
            }
        }

        if(L<=mid){
            for(int i=L; i<=mid; i++){
                sortedArr[idx++] = arr[i];
                findNum(++count,idx-1);
            }
        } else {
            for(int i=R; i<=right; i++){
                sortedArr[idx++] = arr[i];
                findNum(++count,idx-1);
            }
        }


        for(int i=left; i<=right; i++){
            arr[i] = sortedArr[i];
        }


    }

    static void findNum(int num, int idx){
        if(num==K){
            result = sortedArr[idx];
        }
    }
}
