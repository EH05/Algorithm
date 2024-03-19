package boj;

import java.util.Scanner;

public class Q2666 {
    static int[] target;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); // 벽장의 개수


        int first = in.nextInt(); // 열려있는 첫번째 벽장
        int second = in.nextInt(); // 열려있는 두번째 벽장


        int idx = in.nextInt(); // 사용할 벽장들의 순서 길이
        target = new int[idx];
        for(int i=0; i<idx; i++){
            target[i] = in.nextInt();
        }

        int result = getCount(0,first,second);

        System.out.println(result);
    }

    static public int getCount(int dep, int first, int second){
        if(dep == target.length) return 0;

        int case1 = Math.abs(first-target[dep]);
        int case2 = Math.abs(second-target[dep]);

        return Math.min(case1+getCount(dep+1,second,target[dep]), case2+getCount(dep+1,first,target[dep]));
    }

}
