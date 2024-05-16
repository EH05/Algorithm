package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사건의 개수
        int k = Integer.parseInt(st.nextToken()); // 사건의 전후 관계의 개수

        boolean[][] map = new boolean[n + 1][n + 1];


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
        }

        // 연결되어있다면 true 갱신
        for(int temp=1; temp<n+1; temp++) {
            for(int i=1; i<n+1; i++) {
                for(int j=1; j<n+1; j++) {
                    if(map[i][temp] && map[temp][j]) {
                        map[i][j] = true;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        for(int i=0; i<s; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(map[a][b]){
                System.out.println(-1);
            } else {
                if(map[b][a]){
                    System.out.println(1);
                } else{
                    System.out.println(0);
                }
            }
        }
    }
}
