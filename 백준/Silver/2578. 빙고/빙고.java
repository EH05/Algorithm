import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] check;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        check = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                checkMap(num);
                if (count >= 5) {
                    if (checkBingo()) {
                        System.out.println(count);
                        return;
                    }
                }
            }

        }

    }

    public static void checkMap(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == num) {
                    check[i][j] = true;
                    count++;
                    return;
                }
            }
        }
    }

    public static boolean checkBingo() {
        int line = 0;


        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (check[i][j]) cnt++;
            }
            if (cnt == 5) line++;
        }

        for (int j = 0; j < 5; j++) {
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (check[i][j]) cnt++;
            }
            if (cnt == 5) line++;
        }

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < 5; i++) {
            if (check[i][i]) cnt1++;
            if (check[4 - i][i]) cnt2++;  
        }
        if (cnt1 == 5) line++;
        if (cnt2 == 5) line++;


        if (line >= 3) return true;
        return false;

    }
}
