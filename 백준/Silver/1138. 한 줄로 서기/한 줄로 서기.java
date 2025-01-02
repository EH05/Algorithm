import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j=1; j<N+1; j++){
                if(line[j]==0){
                    if(num==0){
                        line[j] = i;
                        break;
                    }
                    num--;
                }
            }
        }

        for(int i=1; i<N+1; i++){
            System.out.print(line[i]+" ");
        }

    }
}
