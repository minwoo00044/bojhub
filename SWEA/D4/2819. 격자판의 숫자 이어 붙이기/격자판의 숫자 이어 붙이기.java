
import java.util.*;
import java.io.*;

class Solution {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
    static Set<Integer> s;
    static char[][] grid;
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st ;
            s = new HashSet<>();
            grid = new char[4][4];
            for(int i = 0; i < 4; i++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	for(int j = 0; j < 4; j++) {
            		grid[i][j] = st.nextToken().charAt(0);
            	}
            }
            for(int i = 0; i < 4; i++) {
            	for(int j = 0; j < 4; j++) {
            		dfs(0,new StringBuilder(),i,j);
            	}
            }
            System.out.println("#"+test_case+" "+s.size());

        }
    }
    static void dfs(int cnt, StringBuilder sb, int r, int c) {
    	if(cnt == 7) {
    		s.add(Integer.parseInt(sb.toString()));
    		return;
    	}
    	for(int i = 0; i < 4; i++) {
    		int nr = r+ dr[i];
    		int nc = c+dc[i];
    		if(!inRange(nr, nc)) continue;
    		sb.append(grid[nr][nc]);
    		dfs(cnt+1, sb, nr, nc);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
    static boolean inRange(int r, int c) {
    	return(r >= 0 && r < 4 && c>=0 && c < 4);
    }
}