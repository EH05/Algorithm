package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class Q1021_회전하는큐 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedList<Integer> dq = new LinkedList<>();

        // 1. 첫번째 원소를 뽑아낸다. -> 큐에도있는 front pop
        // 2. 왼쪽으로 한칸 이동시킨다. -> front를 뽑아서 tail에 push
        // 3. 오른쪽으로 한칸 이동시킨다. -> tail을 뽑아서 front에 push

        int count = 0; // 출력 값(2,3번 연산 횟수)

        int N = in.nextInt(); // 큐의 크기
        int M = in.nextInt(); // 뽑는 수의 갯수

        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        int[] arr = new int[M];

        for (int i = 0; i < M; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < M; i++) {
            // 덱에서 뽑고자 하는 숫자의 위치(Index)
            int numIdx = dq.indexOf(arr[i]);
            int midIdx = 0;

            // 덱 중간지점의 인덱스를 찾는다. (짝수라면 절반크기 -1)
            if (dq.size() % 2 == 0) {
                midIdx = dq.size() / 2 - 1;
            } else {
                midIdx = dq.size() / 2;
            }

            // 인덱스 값끼리 비교하니까 num-1
            // 내가 뽑고자하는게 midIdx보다 앞에 있다면 front를 뽑아서 tail로 보낸다. (2번)
            if (numIdx <= midIdx) {
                for (int j = 0; j < numIdx; j++) {
                    int temp = dq.pollFirst();
                    dq.addLast(temp);
                    count++;

                }
            }
            // midIdx보다 뒤에 있다면 tail을 뽑아서 front로 보낸다. (3번)
            else if (numIdx > midIdx) {
                for (int j = 0; j < dq.size() - numIdx; j++) {
                    int temp = dq.pollLast();
                    dq.addFirst(temp);
                    count++;
                }
            }

            dq.pollFirst();


        }

        System.out.println(count);
    }
}
