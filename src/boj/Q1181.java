package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q1181 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String[] arr = new String[num];

        for (int i = 0; i < num; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (arr[j].length() > arr[j + 1].length()) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }else if(arr[j].length()==arr[j+1].length()) {
                    if(arr[j].compareTo(arr[j+1])>0) {
                        String temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<num-1; i++) {
            if(!arr[i].equals(arr[i+1])) {
                sb.append(arr[i]).append('\n');
            }
        }
        System.out.print(sb);
        System.out.println(arr[num-1]);

    }
}


