
import java.util.*;
import java.io.*;

public class Main {
	static int n,m,grid[][];
	static long ans;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		long[] memo = new long[n+1];
		memo[0] = 0;
		memo[1] = 1;
		for(int i = 2; i < n+1; i++) {
			memo[i] = memo[i-2] + memo[i-1]; 
		}
		System.out.println(memo[n]);
	}
}
