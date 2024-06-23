package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q33023 {
    static char[] light;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        light = new char[N];

        String lights = br.readLine();
        for (int i = 0; i < N; i++) {
            light[i] = lights.charAt(i);
        }



    }



}

