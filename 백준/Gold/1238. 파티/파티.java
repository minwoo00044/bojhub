
import java.util.*;
import java.io.*;

public class Main {
	static int n,m,x;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		List<List<int[]>> adj = new ArrayList<>();
		List<List<int[]>> revAdj = new ArrayList<>();

		for(int i = 0; i < n+1; i++) {
			adj.add(new ArrayList<int[]>());
			revAdj.add(new ArrayList<int[]>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int head = Integer.parseInt(st.nextToken());
			int tail = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			adj.get(head).add(new int[] {tail,val});
			revAdj.get(tail).add(new int[] {head,val});
		}
		int[] toAll = find(x,adj);
		int[] toHome = find(x,revAdj);
		
		int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (toAll[i] != Integer.MAX_VALUE && toHome[i] != Integer.MAX_VALUE) {
                maxTime = Math.max(maxTime, toAll[i] + toHome[i]);
            }
        }
        System.out.println(maxTime);
	}
	static int[] find(int start, List<List<int[]>> graph) {
		int[] dst = new int[n+1];
		Arrays.fill(dst, Integer.MAX_VALUE);
		dst[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		pq.add(new int[] {start,0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int u = cur[0];
			int d= cur[1];
			
			if(d > dst[u]) continue;
			
			for(int[] v : graph.get(u)) {
				int next= v[0];
				int val = v[1];
				if(d+val < dst[next]) {
					dst[next] = d+val;
					pq.add(new int[] {next,dst[next]});
				}
			}
		}
		return dst;
	}
}
