
import java.util.*;
import java.io.*;
class Solution
{
	static int n,ans,ex,ey;
	static int[][] house;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)	{
			n= Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<int[]> added = new ArrayList<int[]>();
			house = new int[n][];
			added.add(new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) });
			ex =Integer.parseInt(st.nextToken());
			ey =Integer.parseInt(st.nextToken());
			for(int i = 0; i < n; i++) {
				house[i] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			}
			boolean[] visited= new boolean[n];
			perm(1,visited,added);
			System.out.println("#"+test_case+" "+ans);
		}
	}
	private static void perm(int cnt,boolean[] visited, List<int[]> added) {
		if(cnt == n+1) {
			calc(added);
			return;
		}
		for(int i = 0; i < house.length;i++) {
			if(!visited[i]) {
				added.add(house[i]);
				visited[i] = true;
				perm(cnt+1,visited,added);
				added.remove(added.size()-1);
				visited[i] = false;
			}
		}
	}
	private static void calc(List<int[]> added) {
		int x = added.get(0)[0];
		int y = added.get(0)[1];
		int total = 0;
		for(int i = 1; i < added.size();i++) {
			int cx = added.get(i)[0];
			int cy = added.get(i)[1];
			
			int dist = Math.abs(cx-x)+Math.abs(cy-y);
			total+=dist;
			if(total > ans) return;
			x= cx;
			y= cy;
		}
		total += Math.abs(ex-x)+Math.abs(ey-y);
		ans = Math.min(ans, total);
	}

}