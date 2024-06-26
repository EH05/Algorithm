package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q16235 {

    static private class Tree implements Comparable<Tree> {
        int r;
        int c;
        int age;
        boolean dead;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "r=" + r +
                    ", c=" + c +
                    ", age=" + age +
                    ", dead=" + dead +
                    '}';
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }

    static List<Tree> trees; // 존재하는 나무들
    static int[][] energy; // 땅에 있는 양분
    static int[][] addEnergy; // 겨울마다 추가되는 양분
    static int N,M,K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N*N 크기의 땅
        M = Integer.parseInt(st.nextToken()); // M개의 나무 구매
        K = Integer.parseInt(st.nextToken()); // K년 후

        energy = new int[N + 1][N + 1];
        addEnergy = new int[N + 1][N + 1];
        trees = new ArrayList<>();

        for (int r = 1; r < N + 1; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c < N + 1; c++) {
                addEnergy[r][c] = Integer.parseInt(st.nextToken());
                energy[r][c] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            trees.add(new Tree(r, c, age));
        }

        Collections.sort(trees);

        while (K-- > 0) {
            Spring();
            Summer();
            Fall();
            Winter();
        }

        int result = 0;
        for (Tree tree : trees) {
            if (!tree.dead) result++;
        }

        System.out.println(result);

    }

    public static void Spring() {
        for (Tree tree : trees) {
            if (!tree.dead) {
                // 양분이 부족하면 나무는 죽는다.
                if (energy[tree.r][tree.c] < tree.age) {
                    tree.dead = true;
                    continue;
                }
                energy[tree.r][tree.c] -= tree.age;
                tree.age++;
            }
        }

    }

    public static void Summer() {
        for (Tree tree : trees) {
            if (tree.dead) {
                energy[tree.r][tree.c] += (tree.age / 2);
            }
        }
    }

    public static void Fall() {
        List<Tree> newTrees = new ArrayList<>();
        for (Tree tree : trees) {
            // 5의 배수가 아니거나, 나무가 죽었으면 넘어감
            if (tree.dead || tree.age % 5 != 0 ) continue;

            int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

            for(int dir=0; dir<8; dir++){
                int nr = tree.r + dr[dir];
                int nc = tree.c + dc[dir];

                if(nr<=0 || nc<=0 || nr>N || nc>N) continue;
                newTrees.add(new Tree(nr,nc,1));
            }
        }

        for(Tree tree: trees){
            if(!tree.dead){
                newTrees.add(tree);
            }
        }

        trees = newTrees;
    }

    public static void Winter(){
        for(int r=1; r<N+1; r++){
            for(int c=1; c<N+1; c++){
                energy[r][c] += addEnergy[r][c];
            }
        }

    }
}
