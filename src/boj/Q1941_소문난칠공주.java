package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 유망하지않은 루트를 포기하는게 백트래킹
// 하지만 이 문제는 결국 완탐을 해야한다.
// 특정 좌표에 도달했을때, 조건에 어긋난다해도, 결국은 돌고돌아 그 좌표를 다시 지날수도 있기때문
public class Q1941_소문난칠공주 {
    static char[][] jari = new char[5][5];
    static boolean[] visited;
    static int[] selected = new int[7];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int count;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int r = 0; r < 5; r++) {
            String line = in.next();
            for (int c = 0; c < 5; c++) {
                jari[r][c] = line.charAt(c);
            }
        }

        backTracking(0, 0, 0);


        System.out.println(count);

    }

    // 0~24중에 무작위로 순서 없이 7개의 숫자를 백트래킹으로 뽑고 기록한다.
    // 기록하다가 Y가 4명 이상이면 제외
    // 기록된 수는 조건에 만족(7명중 Y가 3명 이하) -> 이 7명을 BFS로 돌려준다.
    // BFS로 내가 뽑은 학생들이 연결되어있는지 찾는다.
    public static void backTracking(int seven, int yPa, int start) {
        if (yPa >= 4) return;

        if (seven == 7) {
            visited = new boolean[7];
            BFS();
            return;
        }

        //백트래킹은 0~24이다.
        // 5로 나눈 몫을 행으로, 나머지를 열로 설정하면 5*5 행렬 표현이 가능하다.
        for (int i = start; i < 25; i++) {
            selected[seven] = i;
            if (jari[i / 5][i % 5] == 'Y') {
                backTracking(seven + 1, yPa + 1, i + 1);
            } else {
                backTracking(seven + 1, yPa, i + 1);
            }
        }
    }


    //큐에서 한 명뽑고
    // 해당 친구와 인접한 친구 구해서, 그 친구들이 내가 선택한 다른 S에 포함된다면 연결된 것.
    // 총 7명의 친구들이 연결되어있다면 소문난 칠공주 결성됨.
    public static void BFS() {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{selected[0] / 5, selected[0] % 5});
        visited[0] = true;
        int conn = 1; // 몇개 연결되어있는지

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int ni = nr * 5 + nc; //0~24의 다음 index

                if (!istrue(nr, nc)) continue;

                // 서로 연결되어있는지 검사
                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && selected[j] == ni) {
                        que.add(new int[]{nr, nc});
                        visited[j] = true;
                        conn++;
                    }
                }


            }
        }

        if (conn == 7) count++;
    }

    public static boolean istrue(int r, int c) { //r, c index가 유효한지
        if (r >= 0 && r < 5 && c >= 0 && c < 5) return true;
        return false;
    }

}


