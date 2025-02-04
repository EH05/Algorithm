import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Point implements Comparable<Point> {
        int x;
        int y;
        int rupee;

        public Point(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        @Override
        public int compareTo(Point o) {
            return this.rupee - o.rupee;
        }
    }


    public static StringBuilder sb = new StringBuilder();
    public static int num;
    public static int[][] map;
    public static int[][] visited;
    public static int caseNum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            map = new int[num][num];
            visited = new int[num][num];

            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < num; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                        visited[i][j] = Integer.MAX_VALUE;
                }
            }

            int result = checkMap();

            sb.append("Problem ").append(caseNum++).append(": ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int checkMap() {

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.add(new Point(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if (cur.x == num - 1 && cur.y == num - 1) {
                return cur.rupee;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = cur.x + dr[dir];
                int nc = cur.y + dc[dir];

                if (nr < 0 || nc < 0 || nr > num - 1 || nc > num - 1) continue;

                int newrupee = cur.rupee + map[nr][nc];

                if (visited[nr][nc] > newrupee){
                    visited[nr][nc] = newrupee;
                    pq.add(new Point(nr,nc,newrupee));
                }

            }
        }

        return -1;

    }
}
