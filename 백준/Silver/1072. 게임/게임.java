
import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken()) ;
		long y = Long.parseLong(st.nextToken());
		//y/x = r, y = rx
		long curRating = (long)(y*100/x);
		if(curRating >= 99) {
			System.out.println(-1);
			return;
		}
		long left = 0;
		long right = 1000000000;
		long answer = -1;
		
		while(left <= right) {
			long mid = (left+right)/2;
			long tempRating = (long)((y+mid)*100)/(x+mid);
			if(tempRating >curRating) {
				answer = mid;
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		System.out.println(answer);
	}

}
