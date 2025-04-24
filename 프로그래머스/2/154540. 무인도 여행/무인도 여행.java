import java.io.*;
import java.util.*;

class Solution {
    static char[][] map;
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    
    public class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        visited = new boolean[N][M];
        map = new char[N][M];
        for(int i=0; i<N; i++){
            String line  = maps[i];
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j);
            }
        }
        
        checkMap();
        
        Collections.sort(list);
        int[] answer;
        if(list.size()==0){
            answer = new int[]{-1};
        } else{
            answer = new int[list.size()];

            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
    
    public void checkMap(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] || map[i][j] == 'X') continue;
                int sum = checkIsland(new Point(i,j));
                list.add(sum);
            }
        }
    }
    
    public int checkIsland(Point start){
        Queue<Point> que = new ArrayDeque<>();
        int sum = 0;
        
        que.add(start);
        visited[start.x][start.y] = true;
        sum += map[start.x][start.y] -'0';
        
        while(!que.isEmpty()){
            Point cur = que.poll();
            
            for(int dir=0; dir<4; dir++){
                int nr = cur.x + dr[dir];
                int nc = cur.y + dc[dir];
                
                if(nr<0 || nc<0 || nr>N-1 || nc>M-1 || visited[nr][nc] || map[nr][nc] == 'X') continue;
                
                visited[nr][nc] = true;
                que.add(new Point(nr,nc));
                sum += map[nr][nc] -'0';
            }
        }
        
        return sum;
    }
}