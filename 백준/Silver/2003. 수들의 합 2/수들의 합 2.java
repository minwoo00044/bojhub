
import java.util.*;
import java.io.*;

public class Main {
	static int n,m,grid[][], ans;
	static List<int[]> chickens, house, dists;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		StringTokenizer row = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			int input = Integer.parseInt(row.nextToken());
			nums[i] = input;
		}
		int a = 0;
		int b = 0;
		int sum = 0;
		int ans = 0;
		while(true) {
			if(sum >= m) {
				sum -= nums[a++];
			}else if(b==n) break;
			else if(sum < m) {
				sum += nums[b++];
			}
			if(sum == m) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
