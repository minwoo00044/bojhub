
import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 0;
		int ans = Integer.MAX_VALUE;
		int sum = 0;
		while(true) {
			if(sum >= s) {
				ans = Math.min(ans, right - left);
				sum -= nums[left++];
			} else if(right == n) break;
			else {
				sum+=nums[right++];
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}
