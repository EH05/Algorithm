package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine()); // 전화번호의 수


            String[] arr = new String[n];
            Set<String> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String num = br.readLine();
                arr[i] = num;
                set.add(num);
            }

            Arrays.sort(arr);

            boolean isPossible = true;


            for(int i=0; i<n; i++){
                for(int j=0; j<arr[i].length(); j++){
                    if(set.contains(arr[i].substring(0,j))){
                        isPossible = false;
                        break;
                    }
                }
            }


            if (!isPossible) System.out.println("NO");
            else System.out.println("YES");


        }

    }
}