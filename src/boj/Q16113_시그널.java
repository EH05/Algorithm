package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q16113_시그널 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[5][N/5];
        String line = br.readLine();
        int idx=0;
        for(int r=0; r<5; r++){
            for(int c=0; c<N/5; c++){
                map[r][c] = line.charAt(idx++);
            }
        }


//        for(int i=0; i<5; i++){
//            for(int j=0; j<N/5;  j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

//        String result="";
//        for(int j=0; j<N/5; j++){
//            for(int i=0; i<5;  i++){
//                result+=map[i][j];
//            }
//        }
//        System.out.println(result);



        Queue<String> que = new LinkedList<>();
        for(int c=0; c<N/5; c++){
            for(int r=0; r<5; r++){
                que.add(String.valueOf(map[r][c]));
           }
        }

        while(!que.isEmpty()){
            if(que.peek().equals("#")){
                String num="";
                for(int i=0; i<10; i++){
                    if(que.isEmpty()) break;
                    num+=que.poll();
                }
                if(getNum(num).equals("1") || getNum(num).equals("10")){
                    sb.append(1);
                } else {
                    for(int i=0; i<5; i++){
                        num+=que.poll();
                    }
                    sb.append(getNum(num));
                }


            } else que.poll();
        }

        System.out.println(sb);




    }

    public static String getNum(String num){


       String[] number = new String[11];

       number[0] = "######...######";
       number[1] = "#####.....";
       number[2] = "#.####.#.####.#";
       number[3] = "#.#.##.#.######";
       number[4] = "###....#..#####";
       number[5] = "###.##.#.##.###";
       number[6] = "######.#.##.###";
       number[7] = "#....#....#####";
       number[8] = "######.#.######";
       number[9] = "###.##.#.######";
       number[10] = "#####";

       for(int i=0; i<11; i++){
           if(num.equals(number[i])){
               return String.valueOf(i);
           }
       }
        return num;
    }

}
