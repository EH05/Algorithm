package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String line = br.readLine();

            int left = 0;
            int right = line.length() - 1;

            int count = line.length();

            while (left < right) {
                if (line.charAt(left) == line.charAt(right)) {
                    left++;
                    right--;
                    count -= 2;
                } else if (line.charAt(left) != line.charAt(right)) {
                    int a = checkLine(line, left+1, right);
                    int b = checkLine(line, left, right-1);

                    count = Math.min(a,b);
                    break;
                }

                if (left == right) {
                    count-=1;
                }

            }

            if (count <= 0) {
                sb.append(0).append('\n');
            } else if (count == 1) {
                sb.append(1).append('\n');
            } else {
                sb.append(2).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static int checkLine(String line, int left, int right){
        if(left>right){
            return 1;
        }

        //이미 하나를 삭제 하고 들어옴.
        if(line.charAt(left)==line.charAt(right)){
            return checkLine(line, left+1, right-1);
        }

        return 2;
    }

}
