import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        int V = in.nextInt();

        arr = new int[N + 1][N + 1];


        for (int i = 0; i < M; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }



        visited = new boolean[N + 1];
        DFS(V);

        System.out.println();

        visited = new boolean[N + 1];
        BFS(V);
    }

    static void DFS(int start) {
        stack.add(start);
        visited[start] = true;
        while (!stack.isEmpty()) {
            int num = stack.pop();
            System.out.print(num + " ");
            visited[num] = true;
            for (int i = 0; i <= N; i++) {
                if (arr[num][i] == 1 && !visited[i]) {
                    DFS(i);
                }
            }
        }
    }

    static void BFS(int start) {
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            System.out.print(num + " ");
            for (int i = 0; i <= N; i++) {
                if (arr[num][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}