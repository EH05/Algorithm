package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1296_팀이름정하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String name = in.next();
        int N = in.nextInt();
//        String[] arr = new String[N];

//        for (int i = 0; i < N; i++) {
//            arr[i] = in.next();
//        }

//        Arrays.sort(arr);
        String result_team = null;
        int result = 0;
        int max = -1;

        for (int i = 0; i < N; i++) {
            String team = in.next();
            String love = name + team;

            int L = 0;
            int O = 0;
            int V = 0;
            int E = 0;
            
            for (int j = 0; j < love.length(); j++) {
                switch (love.charAt(j)) {
                    case 'L':
                        L++;
                        break;
                    case 'O':
                        O++;
                        break;
                    case 'V':
                        V++;
                        break;
                    case 'E':
                        E++;
                        break;
                }
            }
            result = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;

            if (max < result || (max == result && team.compareTo(result_team) < 0)) {
                max = result;
                result_team = team;
            }
        }

        System.out.println(result_team);

    }
}
