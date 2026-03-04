
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int n, k, max, remainK;
	static String[] words;
	static boolean[] learned;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer nk = new StringTokenizer(br.readLine());

		max = Integer.MIN_VALUE;
		n = Integer.parseInt(nk.nextToken());
		k = Integer.parseInt(nk.nextToken());
		if (k < 5) {
			System.out.println(0);
			return;
		}
		words = new String[n];
		learned = new boolean[27];
		List<Integer>list = new ArrayList<Integer>();

		String base = "antic";
		for(int i = 0; i < base.length();i++) {
			learned[base.charAt(i)-'a'] = true;
			list.add((int)base.charAt(i));
		}
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			String core = input.substring(4, input.length() - 4);
			words[i] = core;
		}
		
		find('a',5,list);
		System.out.println(max);
	}

	static void find(int alpha, int cnt, List<Integer> selected) {
		if(alpha > 123) return;
		if(cnt == k) {
			int count= check(selected);
			max = Math.max(max, count);
			return;
		}
		if(!learned[alpha-'a']) {
			learned[alpha-'a'] = true;
			selected.add(alpha);
			find(alpha+1,cnt+1,selected);
			learned[alpha-'a'] = false;
			selected.remove(selected.size()-1);
			find(alpha+1,cnt,selected);
		}else {
			find(alpha+1,cnt,selected);

		}

	}
	static int check(List<Integer> combi) {
		int cnt = 0;
		for(String s : words) {
			int correctCnt = 0;
			for(int i = 0; i < s.length(); i++) {
				if(learned[s.charAt(i)-'a']) {
					correctCnt++;
				}
			}
			if(correctCnt == s.length()) {
				cnt++;
			}
		}
		return cnt;
		
	}
}