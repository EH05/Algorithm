package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q15663 {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        visited = new boolean[N];
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        dfs(0, new int[M]);


    }

    public static void dfs(int count, int[] result) {
        System.out.println();
        System.out.println("dfs("+count+")");
        System.out.println(Arrays.toString(result));

        if (count == M) {
            System.out.println("count가 M이므로 출력합니다.");
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            System.out.println("return 됩니다.");
            System.out.println();
            return;
        }

        int compareNum = -1;


        for (int i = 0; i < N; i++) {
            System.out.println("i= "+i+"일때");
            if(!visited[i] && compareNum != arr[i]){
                System.out.println("조건에 부합합니다.");
                visited[i] = true;
                result[count] = arr[i];
                System.out.println("result[count]에 "+arr[i]+"가 저장됩니다.");
                System.out.println("dfs("+(count+1)+")을 불러옵니다.");
                dfs(count+1, result);
                System.out.println("visited를 원상 복구합니다. ");
                visited[i] = false;
                System.out.println("compare를 초기화합니다. compareNum="+arr[i]);
                compareNum = arr[i];
            }
        }
    }
}
