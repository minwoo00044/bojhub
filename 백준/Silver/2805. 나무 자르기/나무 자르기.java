

import java.util.*;
import java.io.*;

public class Main {
	static int n,m,grid[][];
	static long ans;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		long[] nums = new long[n];
		StringTokenizer row = new StringTokenizer(br.readLine());
		ans = Long.MAX_VALUE;
		long max = 0;
		long min = 0;
		
		for(int i = 0; i < n; i++) {
			long input = Long.parseLong(row.nextToken());
			nums[i] = input;
			max = Math.max(max, input);
		}

		while(min <= max) {
			long total = 0;
			long mid = (min+max)/2;
			for(long i : nums) {
				if(i > mid) {
					total += i-mid;
				}
			}
			if(total >=m) {
				ans = mid;
				min = mid+1;
			} else {
				max = mid -1;
			}
		}
		System.out.println(ans);
	}
}
