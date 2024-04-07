package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 배열의 크기

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrA = new int[n * n];
        int[] arrB = new int[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrA[idx] = A[i] + B[j];
                arrB[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

//        System.out.println(Arrays.toString(arrA));
//        System.out.println(Arrays.toString(arrB));

        int left = 0;
        int right = (n * n) - 1;

        long count = 0;

        while (left < (n * n) && right >= 0) {
            int sum = arrA[left] + arrB[right];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                // sum == 0 일때
                int cntA = 1;
                int cntB = 1;
                for (int i = left + 1; i < n * n; i++) {
                    if (arrA[i] != arrA[left]) {
                        break;
                    }
                    cntA++;
                }
                for (int i = right - 1; i >= 0; i--) {
                    if (arrB[i] != arrB[right]) {
                        break;
                    }
                    cntB++;
                }

                count += ((long)cntA * cntB);
                right -= cntB;
                left += cntA;


            }
        }

        System.out.println(count);


    }
}

