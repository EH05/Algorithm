package boj;

import java.util.Scanner;

public class Q3181_줄임말만들기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String[] arr = {"i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"};




        for(int i = 0; in.hasNext(); i++){
            String word = in.next();

            if(i==0) {
                sb.append(word.charAt(0));
            } else {
                boolean isWordMatching = false;
                for (int j = 0; j < arr.length; j++) {
                    if (word.equals(arr[j])) {
                        isWordMatching = true;
                    }
                }
                if(!isWordMatching) {
                    sb.append(word.charAt(0));
                }
            }
        }
        System.out.println(sb.toString().toUpperCase());
    }
}
