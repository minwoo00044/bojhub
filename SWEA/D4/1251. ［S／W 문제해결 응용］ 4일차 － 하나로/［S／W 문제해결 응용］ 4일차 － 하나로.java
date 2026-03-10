
import java.util.*;
import java.io.*;
class Solution
{
	static int n;
	static double p[],xs[],ys[];
	static List<double[]> edges;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)	{
			n= Integer.parseInt(br.readLine());
			StringTokenizer st;
			p = new double[n];
			for(int i = 0; i <n;i++) {
				p[i] = i;
			}
			xs = new double[n];
			ys = new double[n];
			edges = new ArrayList<double[]>();
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
					if(i == j) {
						continue;
					}
					else edges.add(new double[] {i,j, Math.pow(xs[j]-xs[i],2)+Math.pow(ys[j]-ys[i],2)});
				}
			}
			Collections.sort(edges, (a,b)-> Double.compare(a[2], b[2]));
			for(int i = 0; i < edges.size(); i++) {
				if(union(edges.get(i)[0],edges.get(i)[1])) {
					ans += edges.get(i)[2];
				}
			}
			System.out.println("#"+test_case+" "+Math.round(ans * l) );
		}
	}
	static boolean union(double a, double b) {
		a = findSet(a);
		b = findSet(b);
		if(a == b) return false;
		p[(int)b] = a;
		return true;
	}
	private static double findSet(double a) {
		if(p[(int)a] == a) return a;
		return p[(int)a] = findSet(p[(int)a]);
	}
}