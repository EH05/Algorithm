package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q24061 {

    static int N; // 배열의 크기
    static int[] arrA; // 배열
    static int[] sortedArr;
    static int[] arrB;
    static int compareIdx = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arrA = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        arrB = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        sortedArr = arrA.clone();
        checkCompare();
        mergeSort(0, N - 1);

        System.out.println(compareIdx == N ? 1 : 0);
    }

    public static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        int L = left;
        int R = mid + 1;
        int idx = left;

        while (L <= mid && R <= right) {
            if (arrA[L] <= arrA[R]) {
                checkChange(sortedArr[idx], arrA[L], idx);
                sortedArr[idx++] = arrA[L++];
                checkCompare();
            } else {
                checkChange(sortedArr[idx], arrA[R], idx);
                sortedArr[idx++] = arrA[R++];
                checkCompare();
            }
        }

        if (L <= mid) {
            for (int i = L; i <= mid; i++) {
                checkChange(sortedArr[idx], arrA[i], idx);
                sortedArr[idx++] = arrA[i];
                checkCompare();
            }
        } else {
            for (int i = R; i <= right; i++) {
                checkChange(sortedArr[idx], arrA[i], idx);
                sortedArr[idx++] = arrA[i];
                checkCompare();
            }
        }

        for (int i = left; i <= right; i++) {
            arrA[i] = sortedArr[i];
        }
    }

    // 값의 변화가 있고, 비교인덱스가 아직 남아있고(비교가 진행중), 현재 인덱스가 비교 인덱스보다 작은경우
    // => 값의 변화가 비교되지않은 부분에서 발생
    // => 배열 A를 정렬하는 도중, 배열 A와 B의 순서가 달라진 경우
    public static void checkChange(int a, int b, int idx) {
        if(a != b && compareIdx != N && idx < compareIdx) {
            System.out.println(0);
            System.exit(0);
        }
    }

    // 배열 A와 배열 B를 비교하여 현재까지 일치하는 부분 찾아냄
    public static void checkCompare() {
        while (compareIdx < N && sortedArr[compareIdx] == arrB[compareIdx]) {
            // sortedArr : 정렬된 배열 A
            // compareIdx : 현재까지 일치하는 부분의 길이
            // arrB : 비교할 배열 B
            compareIdx++;
        }
    }
}
