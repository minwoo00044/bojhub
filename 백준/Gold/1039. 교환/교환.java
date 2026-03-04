import java.util.*;
import java.io.*;
public class Main {
	static int max = -1;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		String num = st.nextToken();
		int k = Integer.parseInt(st.nextToken());
		find(num,k);
		System.out.println(max);
	}
	
	
	static void find(String start, int k) {
		Queue<Node> q = new LinkedList<Main.Node>();
		boolean[][] visited = new boolean[k+1][10000001];
		q.add(new Node(start, 0));
		visited[0][Integer.parseInt(start)] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.depth >= k) {
				max = Math.max(Integer.parseInt(cur.val), max);
				continue;
			}
			for(int i = 0; i < cur.val.length()-1; i++) {
				for(int j = i+1; j < cur.val.length(); j++) {
					String next = swap(cur.val, i, j);
					if(next != null) {
						int nextInt = Integer.parseInt(next);
						if(!visited[cur.depth+1][nextInt]) {
							visited[cur.depth+1][nextInt] = true;
							q.add(new Node(next, cur.depth+1));
						}
					}
				}
			}
		}
	}
	static String swap(String s, int i , int j) {
		char[] chararr = s.toCharArray();
		char a = chararr[i];
		char b = chararr[j];
		chararr[i] = b;
		chararr[j] = a;
		if(chararr[0] == '0') return null;
		return new String(chararr);
	}
	static class Node{
		String val;
		int depth;
		
		public Node(String val, int depth) {
			this.val = val;
			this.depth = depth;
		}
	}

}
