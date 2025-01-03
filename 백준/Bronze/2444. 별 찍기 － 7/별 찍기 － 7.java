import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = N * 2 - 1;
        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            if (i < num / 2) {
                for (int j = N - i - 1; j > 0; j--) {
                    sb.append(" ");
                }
                for (int k = 0; k < i * 2 + 1; k++) {
                    sb.append("*");
                }
                sb.append("\n");
            }

            if (i == num / 2) {
                for (int j = 0; j < num; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }

            if (i > num / 2) {
                for (int j = 0; j < i - (num / 2); j++) {
                    sb.append(" ");
                }
                for (int k = num - (2*cnt); k > 0; k--) {
                    sb.append("*");
                }
                cnt++;
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}
