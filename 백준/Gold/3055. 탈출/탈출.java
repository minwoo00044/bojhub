
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c, cr, cc, tr, tc, ans;
	static char[][] grid;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static List<int[]> waters;
	static boolean inReached = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer rc = new StringTokenizer(br.readLine());
		r = Integer.parseInt(rc.nextToken());
		c = Integer.parseInt(rc.nextToken());
		grid = new char[r][c];
		waters = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			String row = br.readLine();
			for (int j = 0; j < c; j++) {
				grid[i][j] = row.charAt(j);
				if (grid[i][j] == 'D') {
					tr = i;
					tc = j;
				} else if (grid[i][j] == 'S') {
					cr = i;
					cc = j;
				} else if (grid[i][j] == '*') {
					waters.add(new int[] { i, j });
				}
			}
		}
		simu();
		if (inReached) {
			System.out.println(ans);
		} else {
			System.out.println("KAKTUS");
		}
	}

	static void simu() {
		Queue<int[]> sq = new ArrayDeque<>();
		Queue<int[]> wq = new ArrayDeque<>();

		boolean[][] visited = new boolean[r][c];
		sq.add(new int[] { cr, cc, 0 });
		visited[cr][cc] = true;
		int time = 0;
		for (int i = 0; i < waters.size(); i++) {
			wq.add(new int[] {waters.get(i)[0], waters.get(i)[1]});
		}
		while (!sq.isEmpty()) {
//			for (int i = 0; i < r; i++) {
//				for (int j = 0; j < c; j++) {
//					System.out.print(grid[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("----------------------------------------------------------------------");
			int[] cur = sq.poll();
			int ccr = cur[0];
			int ccc = cur[1];
			int cval = cur[2];
			if(cval > time) {//초가 지났음.
				for(int i = 0; i < wq.size(); i++) {
					int[] originWater = wq.poll();
					int orir = originWater[0];
					int oric = originWater[1];
					for (int j = 0; j < 4; j++) {
						int nr = orir + dy[j];
						int nc = oric + dx[j];
						if (!inRange(nr, nc))
							continue;
						if (grid[nr][nc] == '*' || grid[nr][nc] == 'X' || grid[nr][nc] == 'D')
							continue;
						grid[nr][nc] = '*';
						wq.add(new int[] { nr, nc });

					}
				}
				time = cval;
			}
			for (int i = 0; i < 4; i++) {
				int nr = ccr + dy[i];
				int nc = ccc + dx[i];
				if (!inRange(nr, nc))
					continue;
				if (visited[nr][nc])
					continue;
				if (grid[nr][nc] == 'X' || grid[nr][nc] == '*')
					continue;
				if (grid[nr][nc] == 'D') {
					inReached = true;
					ans = cval + 1;
					return;
				}
				sq.add(new int[] { nr, nc, cval + 1 });
				visited[nr][nc] = true;
			}
		}
	}

	static boolean inRange(int nr, int nc) {
		return (nr >= 0 && nr < r && nc >= 0 && nc < c);
	}

}