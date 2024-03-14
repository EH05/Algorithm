package boj;

import java.util.*;

public class Q11723_홀수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> list = new LinkedList<>();

        int result = 0;

        for (int i = 0; i < 7; i++) {
            int num = in.nextInt();

            if (num % 2 != 0) {
                result += num;
                list.add(num);
            }
        }

        Collections.sort(list);

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
            System.out.println(list.get(0));
        }

    }

}
