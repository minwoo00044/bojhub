
import java.util.*;
import java.io.*;

public class Main {
	static int n,m,grid[][], ans;
	static List<int[]> chickens, house, dists;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grid = new int[n][n];
		chickens = new ArrayList<int[]>();
		house = new ArrayList<int[]>();
		dists = new ArrayList<int[]>();

		ans = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			StringTokenizer row = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(row.nextToken());
				if(grid[i][j] == 1) {
					house.add(new int[] {i,j});
				} else if(grid[i][j] == 2) {
					chickens.add(new int[] {i,j});
				}
			}
		}
		for(int i = 0; i < house.size(); i++) {
			dists.add(new int[chickens.size()]);
			for(int j = 0; j < chickens.size(); j++) {
				int dist = Math.abs(chickens.get(j)[0] - house.get(i)[0])
					+ Math.abs(chickens.get(j)[1] - house.get(i)[1]);
				dists.get(i)[j] = dist;
			}
		}
		combi(0, 0, new boolean[chickens.size()]);
		System.out.println(ans);
	}
	static void combi(int cnt,int idx, boolean[] removed) {
		if(cnt == chickens.size() - m) {
			calc(removed);
			return;
		}
		if(idx == chickens.size()) return;
		
		removed[idx] = true;
		combi(cnt+1,idx+1,removed);
		removed[idx] = false;
		combi(cnt,idx+1,removed);
	}
	private static void calc(boolean[] removed) {
		int ret = 0;
		for(int i = 0; i < dists.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < dists.get(i).length; j++) {
				if(removed[j]) continue;
				min = Math.min(min, dists.get(i)[j]);
			}
			ret += min;
		}
		ans = Math.min(ret, ans);
		return;
	}

}
