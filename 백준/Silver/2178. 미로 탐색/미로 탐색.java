import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] count = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Point> que = new ArrayDeque<>();

        que.add(new Point(0, 0));
        count[0][0] = 1;


        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int nr, nc;
        while (!que.isEmpty()) {
            Point next = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                nr = next.x + dr[dir];
                nc = next.y + dc[dir];

                if (nr < 0 || nc < 0 || nr > n - 1 || nc > m - 1) continue;

                if(arr[nr][nc]==1 && count[nr][nc] == 0){
                    que.add(new Point(nr,nc));
                    count[nr][nc] = count[next.x][next.y] + 1;
                }
            }
        }


        System.out.println(count[n-1][m-1]);


    }
}
