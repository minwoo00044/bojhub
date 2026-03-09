
import java.util.*;
import java.io.*;
class Solution
{
	static int n,m;
	static int[] parents;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)	{
			StringTokenizer nm = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder("#"+test_case+" ");
			int ans = 0;
			n = Integer.parseInt(nm.nextToken());
			m = Integer.parseInt(nm.nextToken());
			parents = new int[n+1];
			for(int i = 0; i < n+1; i++) {
				parents[i] = i;
			}
			for(int i =0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int cmd =  Integer.parseInt(st.nextToken());
				int head = Integer.parseInt(st.nextToken());
				int tail = Integer.parseInt(st.nextToken());
				if(cmd == 0)
					unionSet(head, tail);
				else if(cmd == 1) {
					if(findSet(head) == findSet(tail)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}

			System.out.println(sb.toString());
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = findSet(parents[a]);
	}
	
	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}