package boj;

import java.util.*;

public class Q1781 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 숙제의 개수

        Task[] tasks = new Task[N];
        for (int i = 0; i < N; i++) {
            int dead = in.nextInt(); // 데드라인
            int num = in.nextInt(); // 라면 갯수
            tasks[i] = new Task(dead, num);
        }

        Arrays.sort(tasks, Comparator.comparingInt(Task::getDeadline).reversed());

        int sum = 0;
        int[] finished = new int[N + 1]; // 각 데드라인까지 완료한 라면 갯수를 저장하는 배열

        for (Task task : tasks) {
            int availableIndex = task.deadline;

            while (availableIndex > 0 && finished[availableIndex] != 0) {
                availableIndex--;
            }

            if (availableIndex > 0) {
                sum += task.num;
                finished[availableIndex] = 1;
            }
        }

        System.out.println(sum);
    }

    static class Task {
        int deadline;
        int num;

        Task(int deadline, int num) {
            this.deadline = deadline;
            this.num = num;
        }

        public int getDeadline() {
            return deadline;
        }
    }
}