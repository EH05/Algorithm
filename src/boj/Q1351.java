package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1351 {
    // N이 10^12이기 때문에, hashMap을 사용하여 값을 저장한다.
    // 탑다운 재귀
    static long N;
    static long P;
    static long Q;

    static HashMap<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();

        map.put(0L, 1L); // A0 = 1;
        System.out.println(setValue(N));
    }

    public static long setValue(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        long first = setValue(n / P);
        long second = setValue(n / Q);
        map.put(n, first + second);

        return map.get(n);

    }

}
