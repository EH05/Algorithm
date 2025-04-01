import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int result = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getPoint(0,0);



        System.out.println(result);


    }

    public static void getPoint(int cnt, int sum) {
        if(sum>result) return;

        if (cnt == 3) {
            result = Math.min(result,sum);

            return;
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if (!visited[i][j] && isPossible(i, j)) {
                    change(i,j);
                    int cost = getCost();
                    getPoint(cnt+1, cost);
                    change(i,j);
                }
            }
        }
    }

    public static void change(int r, int c) {
        visited[r][c] = !visited[r][c];

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            visited[nr][nc] = !visited[nr][nc];
        }
    }

    public static boolean isPossible(int r, int c) {

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1 || visited[nr][nc]) {
                return false;
            }
        }

        return true;
    }

    public static int getCost() {
        int cost = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    cost += map[i][j];
                }
            }
        }
        return  cost;
    }
}
