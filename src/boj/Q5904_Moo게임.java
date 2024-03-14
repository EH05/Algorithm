package boj;

import java.util.Scanner;

public class Q5904_Moo게임 {

    static char result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        Moo(num);

        System.out.println(result);
    }

    public static void Moo(int num){
        int size = 3;
        int index = 0;

        if(num==1){
            result ='m';
        } else if(num<=3){
            result = 'o';
        } else{
            while(size < num){
                size = size*2+(index+4);
                index++;
            }

            int lastIdx = (size-index-3)/2;

            if(size-lastIdx+1<=num){
                Moo(num-size+lastIdx);
            } else if(num == lastIdx +1){
                result = 'm';
            } else result ='o';

        }

    }
}
