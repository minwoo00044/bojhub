import java.util.*;
import java.io.*;

public class Main {
	static class Node{
		Node left;
		Node right;
		long val;
		public Node(long val) {
			this.val = val;
		}
	}
	static class MyTree{
		Node root;
		public void add(long val) {
			if (root == null) {
                root = new Node(val);
                return;
            }
            insert(root, val);
		}
		private void insert(Node node, long val) {
            if (val < node.val) {
                if (node.left == null) node.left = new Node(val);
                else insert(node.left, val);
            } else {
                if (node.right == null) node.right = new Node(val);
                else insert(node.right, val);
            }
        }
		public void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
	}
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        MyTree t = new MyTree();
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            t.add(Long.parseLong(input));
        }

        if (t.root != null) {
            t.postOrder(t.root);
        }
    }
}