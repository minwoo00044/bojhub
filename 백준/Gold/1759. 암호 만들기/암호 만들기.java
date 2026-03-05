import java.util.*;
import java.io.*;
public class Main {
	static int l,c;
	static char possible[];
	static String moum = "aeiou";
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		possible = new char[c];
		st =new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) {
			possible[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(possible);
		find(0,0,new ArrayList<Character>());
	}
	static void find(int cnt,int idx, List<Character> added) {
		if(cnt == l) {
			judge(added);
			return;
		}
		if(idx == possible.length) return;
		added.add(possible[idx]);
		find(cnt+1,idx+1,added);
		added.remove(added.size()-1);
		find(cnt,idx+1,added);
		
	}
	private static void judge(List<Character> added) {
		int mCnt = 0;
		int jCnt = 0;
		boolean pass = false;
		for(char i : added) {
			if(moum.contains(i+"")) mCnt++;
			else jCnt++;
		}
		if(mCnt >= 1 && jCnt >= 2) pass = true;
		
		if(pass) {
			for(char c : added) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
