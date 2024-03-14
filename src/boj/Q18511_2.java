package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18511_2 {

    /*
     * k 는 최대 3, n 은 최대 열자리수이므로
     * 가능한 모든 조합을 다 보더라도 최대 59049가지이다.
     * 중복 순열을 통해 가능한 모든 경우를 전부 확인한다.
     */
    static int[] arr;
    static int n;
    static int k;
    static int[] num;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // s = 657
        String s = st.nextToken();

        // num : N 의 자릿수
        // num = 3
        num = new int[s.length()];

        n = Integer.parseInt(s);
        k = Integer.parseInt(st.nextToken());

        // 사용할 수 있는 수를 array 에 담아둔다.
        arr = new int[k];

        // array = [1, 5, 7]
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(st.nextToken());


        ans = 0;
        perm(0, 0);
        System.out.println(ans);

    }

    // 중복 순열
    // depth : 현재 확인할 자리. depth == 0 이면 1의자리, depth == 1이면 10의자리
    // number : 현재까지 확인한 자리들에 채워진 수
    static void perm(int depth, int number) {

        System.out.println("perm에는 "+depth+", "+number+"이 시작됩니다.");

        System.out.println("depth는 "+depth+"입니다.");
        // 가장 앞자리까지 전부 확인했다면 조건에 만족하는 수인지 판단.
        if (depth == num.length) {
            if (number <= n && number > ans) {
                ans = number;
                System.out.println("ans는 "+number+"입니다.");
                System.out.println("return 됩니다.");
                System.out.println();
            }
            return;
        }

        // 10 1 --> 예외 상황 고려
        // 9
        if (depth == num.length - 1) {
            if (number <= n && number > ans) {
                ans = number;
            }
        }

        // 현재 뎁스에서 arr[0] ~ arr[k]까지 전부 넣어본다.
        for (int i = 0; i < k; i++) {

            // arr[i]를 뎁스번째 자리에 넣겠다.
            num[depth] = arr[i];
            System.out.println("num[depth]는 "+ arr[i]+"입니다. ");

            // number 에 계산해준다.
            number += num[depth] * Math.pow(10, depth);
            System.out.println("number에 "+ num[depth] * Math.pow(10, depth)+"을 더해줍니다.");
            System.out.println("number는 "+number+"입니다.");
            System.out.println();

            // 이번 뎁스에서 arr[i]를 넣었으므로 다음 뎁스로 넘어간다.
            // arr[i]를 넣고 계산한 number를 같이 넣어서 보낸다.
            System.out.println("다음 depth로 넘어갑니다.");
            System.out.println("perm에 "+(depth+1)+", "+number+"을 넣어 보냅니다.");
            System.out.println();
            perm(depth + 1, number);

            // 다음 i에 대해서도 확인해야 하므로 number를 원상복구한다.
            number -= num[depth] * Math.pow(10, depth);
            System.out.println("다음 i에 대해 확인하기 위해 number를 원상복구합니다.");
            System.out.println("number = "+number);
        }
    }

}
