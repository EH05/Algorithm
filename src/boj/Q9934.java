package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q9934 {

    static int K;
    static int[] arr;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

         K = Integer.parseInt(br.readLine()); // 깊이가 K인 완전이진트리

        arr= new int[(int) (Math.pow(2,K)-1)];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 방문한 빌딩의 번호 배열
        }

        list = new ArrayList[K+1]; // depth별 빌딩을 넣을 list
        for(int i=1; i<K+1; i++){
            list[i] = new ArrayList<>();
        }

        getTree(0, arr.length-1,1);

        // depth 별 빌딩 위치 출력
        for(int i=1; i<K+1; i++){
            for(int j : list[i]){
                sb.append(j).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    public static void getTree(int start, int end, int depth){

        int root = (start+end)/2; // 완전이진트리이므로, 중간값이 루트

        list[depth].add(arr[root]); // 해당 depth에 빌딩(root) 삽입

        if(depth==K){
            return;
        }
        getTree(start, root-1, depth+1);
        getTree(root+1, end, depth+1);

    }
}
