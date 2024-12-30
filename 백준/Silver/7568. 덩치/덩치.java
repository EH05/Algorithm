import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static class People implements Comparable<People>{
        int weight;
        int height;

        public People(int weight, int height){
            this.weight = weight;
            this.height = height;
        }


        @Override
        public int compareTo(People o) {
            if(this.weight > o.weight && this.height > o.height) {
                return 1;
            } else if(this.weight < o.weight && this.height < o.height){
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        List<People> peopleList = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            peopleList.add(new People(weight, height));
        }

        for(int i=0; i<N; i++){
            int rank = 1;
            for(int j=0; j<N; j++){
                if(i!=j && peopleList.get(j).compareTo(peopleList.get(i))>0){
                    rank++;
                }
            }

            sb.append(rank).append(" ");
        }

        System.out.println(sb);


    }
}
