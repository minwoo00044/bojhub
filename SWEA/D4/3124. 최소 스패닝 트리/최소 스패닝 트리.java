
import java.util.*;
import java.io.*;
class Solution
{
	static int n,p[],edges[][];
	static long ans;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)	{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int v= Integer.parseInt(st.nextToken());
			int e= Integer.parseInt(st.nextToken());
			p = new int[v];
			ans = 0;
			for(int i = 0; i < v; i++) {
				p[i] = i;
			}
			edges = new int[e][];
			for(int i = 0; i < e;i ++) {
				st = new StringTokenizer(br.readLine()," ");
				edges[i] = new int[] {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())};
			
			}
			Arrays.sort(edges, (a,b)-> a[2]-b[2]);
			int cnt = 0;
			for(int i = 0; i < e; i++) {
				if(union(edges[i][0], edges[i][1])) {
					ans+=edges[i][2];
					cnt++;
				}
				if(cnt == v-1) {
					break;
				}
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
	private static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a==b) return false;
		p[b] = a;
		return true;
	}
	private static int findSet(int a) {
		if(p[a] == a) return a;
		return p[a] = findSet(p[a]);
	}

}