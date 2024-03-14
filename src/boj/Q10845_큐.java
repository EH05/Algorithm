package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q10845_큐 {
    public static void main(String[] args) {
        int b=0;
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();

        for(int i=0; i<cnt; i++) {
            String a = in.next();
            if (a.equals("push")) {
                b = in.nextInt();
                que.add(b);
            } else if (a.equals("front")) {
                sb.append(que.isEmpty() ? -1 : que.peek()).append('\n');
            } else if (a.equals("back")) {
                sb.append(que.isEmpty() ? -1 : b).append('\n');
            } else if (a.equals("size")) {
                sb.append(que.size()).append('\n');
            } else if (a.equals("pop")) {
                sb.append(que.isEmpty() ? -1 : que.poll()).append('\n');
            } else if (a.equals("empty")) {
                sb.append(que.isEmpty() ? 1 : 0).append('\n');
            }

        }
        System.out.println(sb.toString());
    }
}
