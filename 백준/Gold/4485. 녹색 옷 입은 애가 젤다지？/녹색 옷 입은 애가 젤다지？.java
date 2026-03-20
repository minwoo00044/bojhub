
import java.util.*;
import java.io.*;

public class Main {
	static int n, grid[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while(tc++ > -1) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			StringBuilder sb = new StringBuilder("Problem "+ tc +":"+ " ");
			grid = new int[n][n];
			for(int r = 0; r < n; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < n; c++) {
					grid[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dst = new int[n][n];
			for(int i = 0 ; i < n; i++) {
				Arrays.fill(dst[i], Integer.MAX_VALUE);

			}
			dst[0][0] = grid[0][0];
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] - b[2]);
			pq.add(new int[] {0,0,grid[0][0]});
			
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				int r = cur[0];
				int c = cur[1];
				int d = cur[2];
				if(d>dst[r][c]) continue;
				if(r == n-1 && c == n-1) {
					sb.append(d);
					break;
				}
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if(!inRange(nr, nc)) continue;
					if(d + grid[nr][nc] >= dst[nr][nc]) continue;
					dst[nr][nc] = d + grid[nr][nc];
					pq.add(new int[] {nr,nc,d+grid[nr][nc]});
				}
			}
			System.out.println(sb.toString());
		} 
	}
	static boolean inRange(int r, int c) {
		return (r >=0 && r < n && c >= 0 && c < n);
	}

}
