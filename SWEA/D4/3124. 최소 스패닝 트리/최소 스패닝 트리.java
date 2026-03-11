
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
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int v= Integer.parseInt(st.nextToken());
            int e= Integer.parseInt(st.nextToken());
            long ans = 0;
            List<Vertex>[] adj = new ArrayList[v];
            for(int i = 0; i < v; i++) {
            	adj[i] = new ArrayList<Vertex>();
            }
            for(int i = 0; i < e;i ++) {
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                int w = Integer.parseInt(st.nextToken());
                adj[from].add(new Vertex(to, w));
                adj[to].add(new Vertex(from, w));
            }
            PriorityQueue<Vertex> pq = new PriorityQueue<>();
            boolean[] visited= new boolean[v];
            pq.offer(new Vertex(0, 0));
            int pick = 0;
            while(!pq.isEmpty()) {
            	Vertex vt = pq.poll();
            	if(visited[vt.no])continue;
            	ans+=vt.weight;
            	visited[vt.no] = true;
            	if(++pick == v) break;
            	pq.addAll(adj[vt.no]);
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}