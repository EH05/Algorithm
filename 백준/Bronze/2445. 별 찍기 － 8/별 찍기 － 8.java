import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] result = new char[N*2-1][N*2];

        for(int i=0; i<N*2-1; i++){
            for(int j=0; j<N*2; j++){
                result[i][j] = '*';
            }
        }

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N*2-i-1; j++){
                result[i][j] = ' ';
            }
        }

        for(int i=N-1; i>=0; i--){
            for(int j=i+1; j<N*2-i-1; j++){
                result[N*2-2-i][j] = ' ';
            }
        }




        for(int i=0; i<N*2-1; i++){
            for(int j=0; j<N*2; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
