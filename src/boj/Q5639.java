package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5639 {
    static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
        }

        void insert(int n) {
            // n이 작으면 왼쪽 자식으로 들어감.
            if (n < this.num) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
                // n이 크면 오른쪽 자식으로 들어감.
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = null;
        Node root = new Node(Integer.parseInt(br.readLine()));
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);

            root.insert(n);
        }

        postOrder(root);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);

    }
}
