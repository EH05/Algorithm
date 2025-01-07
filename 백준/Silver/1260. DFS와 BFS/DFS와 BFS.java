import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> que = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        visit = new boolean[node + 1];
        dfs(start);

        sb.append("\n");

        visit = new boolean[node+1];
        bfs(start);

        System.out.println(sb);

    }

    public static void dfs(int start){
        visit[start] = true;
        sb.append(start).append(" ");

        for(int i=1; i<node+1; i++){
            if(arr[start][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()){
            start = que.poll();
            sb.append(start).append(" ");

            for(int i=1; i<node+1; i++){
                if(arr[start][i]==1 && !visit[i]){
                    que.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
