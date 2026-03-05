import java.util.*;
import java.io.*;
public class Main {
	static int max = -1;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		Set<Integer> a = new HashSet<>();
		for(int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		st =new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			if(a.contains(Integer.parseInt(st.nextToken()))) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

}
