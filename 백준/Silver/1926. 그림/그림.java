import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static boolean[][] visited;
    static int[][] map;
    static int cnt;
    static int maxC;

    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로 크기
        m = Integer.parseInt(st.nextToken()); // 가로 크기

        visited = new boolean[n][m];
        map = new int[n][m];

        for(int r=0; r<n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<m; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(!visited[r][c] && map[r][c] == 1){
                    visited[r][c]=true;
                    int count = getPaint(r,c,1);
                    cnt++;
                    maxC = Math.max(maxC, count);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxC);

    }

    public static int getPaint(int r, int c, int count){
        for(int dir=0; dir<4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr<0 || nr>n-1 || nc<0 || nc>m-1) continue;
            if(visited[nr][nc] || map[nr][nc]==0) continue;

            visited[nr][nc] =true;
            count = getPaint(nr,nc, count+1);
        }

        return count;
    }
}