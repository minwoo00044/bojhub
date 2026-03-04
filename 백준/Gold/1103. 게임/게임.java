

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.*;
public class Main {

	static int n, m,ans;
	static char[][] map;
	static boolean[][] visited;
	static boolean cycle = false;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] memo;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());;
		visited = new boolean[n][m];
		map = new char[n][m];
		memo = new int[n][m];
		for(int i = 0; i < n; i++) {
			String row= br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = row.charAt(j);
			}
		}
		memo = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(memo[i], -1); // 아직 방문 안 함을 -1로 초기화

        ans = simu(0, 0);
        System.out.println(cycle ? -1 : ans);
	}
	static int simu(int r, int c) {
        if (visited[r][c]) {
            cycle = true;
            return -1;
        }
        
        if (memo[r][c] != -1) return memo[r][c];

        visited[r][c] = true;
        int maxMove = 0;
        int step = map[r][c] - '0';

        for (int i = 0; i < 4; i++) {
            int nr = r + dy[i] * step;
            int nc = c + dx[i] * step;

            if (inRange(nr, nc) && map[nr][nc] != 'H') {
                int next = simu(nr, nc);
                if (cycle) return -1; 
                maxMove = Math.max(maxMove, next);
            }
        }

        visited[r][c] = false; 
        return memo[r][c] = maxMove + 1; 
    }
	static boolean inRange(int r, int c) {
		return(r >= 0 && r < n&& c >=0 && c < m);
	}
}