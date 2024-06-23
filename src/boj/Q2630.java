package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630 {

    static int white;
    static int blue;
    static int[][] paper;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 변의 길이
        paper = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(white);
        System.out.println(blue);


    }

    public static void dfs(int row, int col, int len) {

        if(checkColoer(row,col,len)){
            if(paper[row][col]==1){
                blue++;
            } else {
                white++;
            }
            return;
        }


        dfs(row, col, len / 2);
        dfs(row, col + len / 2, len / 2);
        dfs(row + len / 2, col, len / 2);
        dfs(row + len / 2, col + len / 2, len / 2);

    }

    public static boolean checkColoer(int row, int col, int len) {
        int ref = paper[row][col];
        for (int r = row; r < row + len; r++) {
            for (int c = col; c < col + len; c++) {
                if (paper[r][c] != ref) {
                    return false;
                }
            }
        }
        return true;
    }
}
