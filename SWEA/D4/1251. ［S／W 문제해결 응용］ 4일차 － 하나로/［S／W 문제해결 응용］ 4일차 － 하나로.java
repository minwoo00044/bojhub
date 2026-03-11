
import java.util.*;


import java.io.*;
class Solution
{
    static int n;
    static double xs[],ys[];    
	static class Vertex implements Comparable<Vertex>{
		public Vertex(int no, double weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		int no;
		double weight;
		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)  {
            n= Integer.parseInt(br.readLine());
            StringTokenizer st;
    		List<Vertex>[] adj = new ArrayList[n];
    		for(int i = 0; i < n; i++) {
    			adj[i] = new ArrayList<>();
    		}
            xs = new double[n];
            ys = new double[n];
            st = new StringTokenizer(br.readLine()," ");
 
            for(int i = 0; i < n; i++) {
                xs[i] = Double.parseDouble(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < n; i++) {
                ys[i] = Double.parseDouble(st.nextToken());
            }
            double l = Double.parseDouble(br.readLine());
            double ans = 0;
            for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		adj[i].add(new Vertex(j, Math.pow(xs[j]-xs[i],2)+Math.pow(ys[j]-ys[i],2)));
            		adj[j].add(new Vertex(i, Math.pow(xs[j]-xs[i],2)+Math.pow(ys[j]-ys[i],2)));
            	}
            }
    		boolean[] visited = new boolean[n];
    		PriorityQueue<Vertex> pq = new PriorityQueue<>();
    		int pick = 0;
    		pq.offer(new Vertex(0, 0));
    		
    		while(!pq.isEmpty()) {
    			Vertex v= pq.poll();
    			if(visited[v.no]) continue;
    			ans+= v.weight;
    			visited[v.no] = true;
    			if(++pick == n) break;
    			pq.addAll(adj[v.no]);
    		}
    		ans *= l;
            System.out.println("#"+test_case+" "+Math.round(ans));

        }
    }
}