
import java.util.*;
import java.io.*;

class Solution {
    static int n, w, h, ans, totalBricks;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            int[][] grid = new int[h][w];
            totalBricks = 0;
            ans = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if (grid[i][j] > 0) totalBricks++;
                }
            }

            dfs(0, 0, grid);
            // 남은 벽돌의 최소 개수 = 전체 벽돌 - 최대 제거 개수
            System.out.println("#" + test_case + " " + (totalBricks - ans));
        }
    }

    static void dfs(int cnt, int destroyed, int[][] currentGrid) {
    	if(cnt == n || destroyed == totalBricks) {
    		ans = Math.max(ans, destroyed);
    		return;
    	}
    	for(int i = 0; i < w; i++) {
    		int he = -1;
    		for(int row = 0; row < h; row++) {
    			if(currentGrid[row][i] != 0) {
    				he = row;
    				break;
    			}
    		}
    		if(he == -1 )continue;
    		int[][] copy = copyGrid(currentGrid);
    		int plus = crash(copy, he, i);
    		applyGravity(copy);
    		dfs(cnt+1, destroyed +plus,copy);
    	}
    }

    static int crash(int[][] map, int r, int c) {
    	int ret = 0;
    	Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {r,c,map[r][c]});
		map[r][c] = 0;
		ret++;

    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int cr = cur[0];
    		int cc = cur[1];
    		int power = cur[2];
    		for(int d = 0; d <4; d++) {
    			for(int p = 1; p <power; p++) {
    				int nr = cr + dr[d] * p;
    				int nc = cc + dc[d] * p;
    				if(!inRange(nr, nc)) break;
    				 if(map[nr][nc] != 0) {
    		    		q.add(new int[] {nr,nc,map[nr][nc]});
    		    		map[nr][nc] = 0;
    		    		ret++;
    				}
    			}
    		}
    	}
    	return ret;
    }
    static boolean inRange(int r, int c) {
    	return (r >=0 && r < h && c >=0 && c < w);
    }
    static void applyGravity(int[][] map) {
    	for(int c = 0; c < w; c++) {
    		int target = h-1;
    		for(int r = h-1; r >=0; r--) {
    			if(map[r][c] != 0) {
    				int temp = map[r][c];
    				map[r][c] = 0;
    				map[target--][c] = temp;
    			}
    		}
    	}
    }

    static int[][] copyGrid(int[][] origin) {
        int[][] copy = new int[h][w];
        for (int i = 0; i < h; i++) {
            copy[i] = origin[i].clone();
        }
        return copy;
    }
}