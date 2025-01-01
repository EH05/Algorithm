import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[9];

        int result = 0;

        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            int val = N % 10;
            if (val == 9) val = 6;

            num[val]++;

            N = N / 10;
        }

        if(num[6] !=0 && num[6]%2==0){
            num[6]= num[6]/2;
        } else if(num[6] != 0) {
            num[6] = num[6]/2 +1;
        }

        for(int i=0; i<9;i++){
            result = Math.max(num[i], result);
        }
        System.out.println(result);


    }
}
