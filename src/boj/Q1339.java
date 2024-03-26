package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Q1339 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int[] alphabet = new int[26];

        for (int i = 0; i < N; i++) {
            int temp = (int) Math.pow(10, words[i].length() - 1);
            for (int j = 0; j < words[i].length(); j++) {
                alphabet[(int) words[i].charAt(j) - 65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alphabet);

//        System.out.println(Arrays.toString(alphabet));

        int num = 9;

        int sum = 0;

        for (int i = alphabet.length - 1; i >= 0; i--) {
            if (alphabet[i] == 0) break;

            sum += alphabet[i] * num--;
        }


        System.out.println(sum);


    }

}
