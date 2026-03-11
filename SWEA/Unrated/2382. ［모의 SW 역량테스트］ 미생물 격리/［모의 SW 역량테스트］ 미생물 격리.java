

import java.util.*;
import java.io.*;
class Solution
{
	static int n,m,k,grid[][],dir[][];
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,-1,1};
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)	{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			grid = new int[n][n];
			dir = new int[n][n];
			Queue<int[]> micros = new ArrayDeque<int[]>();
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				grid[r][c] = Integer.parseInt(st.nextToken());
				dir[r][c] = Integer.parseInt(st.nextToken());
				micros.add(new int[] {r,c});
			}
			int totalMicro = 0;
			//print();
			for(int t = 0; t < m; t++) {
				int[][] copyGrid= new int[n][n];
				int[][] copyDir= new int[n][n];
				int[][] max = new int[n][n];
				int size = micros.size();
				int currentSecondMicroTotal = 0;
				for(int i = 0; i < size; i++) {
					int[] cur= micros.poll();
					int cr = cur[0];
					int cc = cur[1];
					int cVal = grid[cr][cc];
					int cDir = dir[cr][cc];
					
					int nr = cr + dr[cDir];
					int nc = cc + dc[cDir];
					int nval = cVal;
					int nDir= cDir;
					if(!inRange(nr, nc)) {
						nval /=2;
						if(nDir==1)nDir = 2;
						else if(nDir==2)nDir = 1;
						else if(nDir==3)nDir = 4;
						else if(nDir==4)nDir = 3;
					}
					currentSecondMicroTotal+=nval;
					if(copyGrid[nr][nc] == 0 && nval>0) {
						micros.add(new int[] {nr,nc});

					}
					if(nval > 0) {
						if(max[nr][nc] != 0) {
							if(nval > max[nr][nc]) {
								max[nr][nc] = nval;
							} else {
								nDir = copyDir[nr][nc];
							}
						} else {
							max[nr][nc] = nval;
						}
						copyGrid[nr][nc] += nval;
						copyDir[nr][nc] = nDir;
					}

				}
				grid = copyGrid;
				dir = copyDir;
				//print();

				totalMicro = currentSecondMicroTotal;
			}
			System.out.println("#"+test_case+" "+totalMicro);
		}
	}
	static boolean inRange(int r, int c) {
		return(r >= 1 && r < n-1 && c >=1 && c <n-1);
	}
	static void print() {
		System.out.println("--------------grid-----------");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------dir-----------");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(dir[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------");
	}
}