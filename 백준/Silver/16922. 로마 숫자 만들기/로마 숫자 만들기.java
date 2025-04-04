import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static int[] arr = {1, 5, 10, 50};
    static int N;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();


        getCount(0,0,0);


        System.out.println(set.size());


    }

    public static void getCount(int cnt, int sum, int idx){
        if(cnt==N){
            set.add(sum);
            return;
        }

        for(int i=idx; i<4; i++){
            getCount(cnt+1, sum+arr[i], i);
        }
    }
}
