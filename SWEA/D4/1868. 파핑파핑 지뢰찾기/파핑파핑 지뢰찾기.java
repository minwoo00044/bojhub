
import java.util.*;
import java.io.*;
class Solution
{
	static int n,m,visitCnt,bombCnt;
	static char[][] grid;
	static int[] parents;
	static int[] dr = {-1,1,0,0,-1,1,-1,1};
	static int[] dc = {0,0,-1,1,-1,-1,1,1};
	static boolean visited[][];
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)	{
			n= Integer.parseInt(br.readLine());
			visitCnt = 0;
			bombCnt = 0;
			grid = new char[n][n];
			visited= new boolean[n][n];
			for(int i = 0; i < n; i++) {
				String row = br.readLine();
				for(int j = 0; j < n; j++) {
					grid[i][j] = row.charAt(j);
					if(grid[i][j] == '*') bombCnt++;
				}
			}
			int ans = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(grid[i][j] == '.') {
						int sCnt =  bombCnt8Dir(i, j);
						if(sCnt == 0) {
							grid[i][j] = Character.forDigit(sCnt, 10);
							bfs(i,j);
							ans++;
						}
					} 
				}
			}
			ans += (n*n) - visitCnt - bombCnt;
			System.out.println("#"+test_case+" "+ans);
		}
	}
	static void bfs(int sr, int sc) {
		visited[sr][sc] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sr,sc});
		visitCnt++;

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 8; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1]+ dc[i];
				if(!inRange(nr, nc)||visited[nr][nc]||
						grid[nr][nc] =='*') continue;
				visitCnt++;
				int cnt = bombCnt8Dir(nr, nc);
				grid[nr][nc] =Character.forDigit(cnt, 10);
				visited[nr][nc] = true;
				if(cnt == 0) {
					q.add(new int[] {nr,nc});
				}
			}
		}
	}
	
	static boolean inRange(int r, int c) {
		return (r >=0 && r < n && c>= 0 && c <n);
	}
	static int bombCnt8Dir(int r, int c) {
		int ret = 0;
		for(int i =0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c+ dc[i];
			if(!inRange(nr, nc)) continue;
			if(grid[nr][nc] == '*') ret++;
		}
		return ret;
	}
}