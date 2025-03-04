import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] peopleNum;
    static List<Integer>[] list;
    static int answer = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 구역의 개수

        peopleNum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            peopleNum[i] = Integer.parseInt(st.nextToken());
        }


        list = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }


        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++){
                int next = Integer.parseInt(st.nextToken());
                list[i].add(next);
            }
        }
        // 초기화 끝

        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=1; i<=N/2; i++){
            comb(1,i,temp);
        }

        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }

        System.out.println(answer);

    }

    public static void comb(int start, int num, ArrayList<Integer> temp){
        if(num==0){
            gerrymandering(temp);
            return;
        }



        for(int i=start; i<N+1; i++){
            temp.add(i);
            comb(i+1, num-1, temp);
            temp.remove(temp.size()-1);
        }
    }


    public static void gerrymandering(ArrayList<Integer> A){
        if(!isConnect(A.get(0), A, A.size())){
            return;
        }

        ArrayList<Integer> B = new ArrayList<>();
        for(int i=1; i<N+1; i++){
            if(A.contains(i)){
                continue;
            }
            B.add(i);
        }

        if(!isConnect(B.get(0),B,B.size())){
            return;
        }

        int a_peopleNum = 0;
        int b_peopleNum = 0;

        for(int i=0; i<A.size(); i++){
            a_peopleNum += peopleNum[A.get(i)];
        }

        for(int i=0; i<B.size(); i++){
            b_peopleNum += peopleNum[B.get(i)];
        }

        int result = Math.abs(a_peopleNum - b_peopleNum);
        answer = Math.min(answer,result);


    }

    // 해당 선거구가 모두 연결되어있는지 확인
    public static boolean isConnect(int num, ArrayList<Integer> A, int size){
        boolean[] visited = new boolean[N+1];
        visited[num] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(num);

        int count = 1;
        Set<Integer> set = new HashSet<>(A);

        while(!que.isEmpty()){
            int start = que.poll();
            for(int i : list[start]){
                if(!visited[i] && set.contains(i)){
                    visited[i] = true;
                    count++;
                    que.add(i);
                }
            }
        }

        if(count == size){
            return true;
        }
        return false;


    }




}