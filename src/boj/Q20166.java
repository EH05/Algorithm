package boj;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q20166 {

    static char[][] map;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static Map<String, Integer> hashmap;
    static int N, M;

    public static class Pair {
        int r;
        int c;
        String str;

        static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        public Pair() {
        }

        public Pair(int r, int c, String str) {
            this.r = r;
            this.c = c;
            this.str = str;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "r=" + r +
                    ", c=" + c +
                    ", str='" + str + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 격자의 크기 N
        M = Integer.parseInt(st.nextToken()); // 격자의 크기 M
        int K = Integer.parseInt(st.nextToken()); // 문자열의 개수 K

        map = new char[N][M];
        hashmap = new HashMap<>(); //해당 문자열이 나오는 경우의수를 저장.

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c);
            }
        }

        String[] arr = new String[K]; // K개의 문자열
        for (int i = 0; i < K; i++) {
            arr[i] = br.readLine();
            hashmap.put(arr[i], 0);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                bfs(r, c);
            }
        }

        for (int i = 0; i < K; i++) {
            sb.append(hashmap.get(arr[i])).append('\n');
        }

        System.out.println(sb);
    }

    public static void bfs(int r, int c) {
//      System.out.println("============r,c => "+r+","+c);
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(r, c, map[r][c] + ""));
        while (!que.isEmpty()) {
            Pair curr = que.poll();
//           System.out.println(curr.toString());
            if (hashmap.containsKey(curr.str)) {
                hashmap.put(curr.str, hashmap.get(curr.str) + 1);
            }
            if (curr.str.length() == 5) continue; // 신이 좋아하는 문자열의 길이는 5이하
            // 일치하면 hashmap에 경우의 수 추가
            for (int dir = 0; dir < 8; dir++) {
                int nr = (curr.r + dr[dir]) % N;
                int nc = (curr.c + dc[dir]) % M;

                if (nr < 0) nr += N;
                if (nc < 0) nc += M;

//               System.out.println("만들어진 str= "+curr.str+map[nr][nc]);
                que.add(new Pair(nr, nc, curr.str + map[nr][nc]));

            }

        }


    }
}
