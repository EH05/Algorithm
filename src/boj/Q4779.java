package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4779 {

    static char[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num;
        while((num = br.readLine())!=null){
            int N = Integer.parseInt(num);

            int len = (int) Math.pow(3,N);
            result= new char[len];
            for(int i=0; i<len; i++){
                result[i] = '-';
            }

            answer(0, len);
            System.out.println(result);
        }
    }

    public static void answer(int idx, int len){
        if(len<3){
            return;
        }


        for(int i=idx+len/3; i<idx+len/3*2; i++){
            result[i] = ' ';
        }

        answer(idx, len/3);
        answer(idx+len/3*2, len/3);

    }
}
