
import java.util.*;
import java.io.*;


public class Main {
	static int max, min,grid[][];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		grid = new int[n][3];
		min = Integer.MAX_VALUE;
		int[] maxdp = new int[3];
		int[] mindp = new int[3];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				maxdp[0] = mindp[0] = a;
				maxdp[1] = mindp[1] = b;
				maxdp[2] = mindp[2] = c;
			} else {
				int pmaxa = maxdp[0]; 
				int pmaxb = maxdp[1];
				int pmaxc = maxdp[2];
				
				maxdp[0] = Math.max(pmaxa, pmaxb) + a;
				maxdp[1] = Math.max( Math.max(pmaxa, pmaxb), pmaxc) + b;
				maxdp[2] = Math.max(pmaxb, pmaxc) + c;

				int pmina = mindp[0]; 
				int pminb = mindp[1];
				int pminc = mindp[2];
				
				mindp[0] = Math.min(pmina, pminb) + a;
				mindp[1] = Math.min( Math.min(pmina, pminb),  pminc) + b;
				mindp[2] = Math.min(pminb, pminc) + c;
			}
  		}
		max = Math.max( Math.max(maxdp[0], maxdp[1]), maxdp[2]);
		min = Math.min( Math.min(mindp[0], mindp[1]),  mindp[2]);

		System.out.print(max+" "+min);
	}

}
