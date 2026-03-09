
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
			int ans = 0;
			n = Integer.parseInt(nm.nextToken());
			m = Integer.parseInt(nm.nextToken());
			parents = new int[n+1];
			for(int i = 0; i < n+1; i++) {
				parents[i] = i;
			}
			for(int i =0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int head = Integer.parseInt(st.nextToken());
				int tail = Integer.parseInt(st.nextToken());
				unionSet(head, tail);
			}
			for(int i = 1; i < n+1; i++) {
				if(parents[i] == i) {
					ans++;
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = findSet(parents[a]);
	}
	
	static void unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		parents[bRoot] = aRoot;
		return;
	}
}