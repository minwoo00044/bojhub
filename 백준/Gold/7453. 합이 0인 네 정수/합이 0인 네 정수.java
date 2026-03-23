
import java.util.*;
import java.io.*;

public class Main {
	static int n, grid;
	static int[] a,b,c,d;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		c = new int[n];
		d = new int[n];
		
		int idx = 0;
		for(int i = 0; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[idx] = Integer.parseInt(st.nextToken());
			b[idx] = Integer.parseInt(st.nextToken());
			c[idx] = Integer.parseInt(st.nextToken());
			d[idx] = Integer.parseInt(st.nextToken());
			idx++;
			
		}
		int[] ab = new int[n*n];
		int[] cd = new int[n*n];
		int index = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ab[index] = a[i] + b[j];
				cd[index++] = c[i]+d[j];
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		int left = 0;
		int right = n*n-1;
		long ans = 0;
		while (left < n * n && right >= 0) {
			long sum = (long)ab[left] + cd[right];
			if(sum > 0) {
				right--;
			}else if(sum == 0) {
				long targetAB  = ab[left];
				long cntAB = 0;
				while(left < n*n && ab[left]==targetAB) {
					cntAB++;
					left++;
				}
				
				long targetCD = cd[right];
				long cntCD = 0;
				while(right >= 0 && cd[right]==targetCD) {
					cntCD++;
					right--;
				}
				ans+=cntAB*cntCD;
			}else {
				left++;
			}
		}
		System.out.println(ans);
	}
}
