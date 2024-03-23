package boj;

import java.util.*;

public class Q12904 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        String S = in.next();
        String T = in.next();

        for(int i=0; i<T.length(); i++) {
            list.add(T.charAt(i)+"");
        }

        boolean isReverse = false;

        while (true) {
            if (S.length() == list.size()) {
                if(isReverse) {
                    Collections.reverse(list);
                }
                String result = String.join("",list);
                System.out.println(S.equals(result) ? 1 : 0);
                break;
            }

            int index = isReverse ?  0 : list.size()-1;

            if (list.get(index).equals("A")){
                list.remove(index);
            } else if(list.get(index).equals("B")){
                list.remove(index);
                isReverse = !isReverse;
            }
        }

    }
}
