package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q22945 {

    static class Developer {

        int idx;
        int value;

        public Developer(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Developer{" +
                    "idx=" + idx +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Developer[] developers = new Developer[N];
        for (int i = 0; i < N; i++) {
            developers[i] = new Developer(i, Integer.parseInt(st.nextToken()));
        }

        // value(능력치) 내림차순 정렬
        Arrays.sort(developers, (o1, o2) -> Integer.compare(o2.value, o1.value));


        // 능력치 가장 큰값 2명 개발자 선택해서 power 구함
        int max = getPower(developers[0].idx, developers[1].idx, developers[1].value);
        // 두 개발자의 위치 min, max 저장
        int maxIdx = Math.max(developers[0].idx, developers[1].idx);
        int minIdx = Math.min(developers[0].idx, developers[1].idx);


        for (int i = 2; i < N; i++) {
            // 능력치 순으로 순차 탐색

            // i번째 개발자는 0 ~ (i-1) 까지의 개발자의 능력치보다 낮으므로, 굳이 min값을 구할 필요가 없음.
            // 따라서 내 i-1 까지의 개발자 중에 가장 먼 거리에 있는 개발자를 기준으로 i번째 개발자가 선택됐을때의 power의 최대값을 구할 수 있다

            // 먼 거리에 있는 개발자를 찾는 방법은 minIdx, maxIdx를 이용한다.
            int farIdx = Math.abs(maxIdx - developers[i].idx) > Math.abs(minIdx - developers[i].idx) ? maxIdx : minIdx;
            int power = getPower(farIdx, developers[i].idx, developers[i].value);
            max = Math.max(max, power);

            // 0부터 i번째 개발자의 위치 min, max 갱신
            maxIdx = Math.max(developers[i].idx, maxIdx);
            minIdx = Math.min(developers[i].idx, minIdx);
        }

        System.out.println(max);
    }

    private static int getPower(int idx1, int idx2, int lowValue) {
        return (Math.abs(idx1 - idx2) - 1) * lowValue;
    }
}