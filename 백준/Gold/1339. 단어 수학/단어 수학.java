
import java.util.*;
import java.io.*;

public class Main {
	static int n;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Character, Integer> map = new HashMap<Character, Integer>(); 
		String[] nums = new String[n];
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			nums[i] = row;
			double length = row.length();
			for(int j = 0; j < row.length(); j++) {
				if(!map.containsKey(row.charAt(j))) {
					map.put(row.charAt(j), 0);
				}
				int origin = map.get(row.charAt(j));
				int offset = (int)(Math.pow(10,length-1-j));
				map.replace(row.charAt(j), origin, origin+offset);
			}
		}
		List<Character> keys = new ArrayList<Character>(map.keySet());
		Collections.sort(keys, (a,b)-> map.get(b) - map.get(a));
		Map<Character, Integer> mapper = new HashMap<Character, Integer>(); 

		for(int i = 0; i < keys.size(); i++) {
			mapper.put(keys.get(i), 9-i);
		}
		int total = 0;
		for(int i = 0; i < nums.length; i++) {
			int rowNum = 0;
			for(int j = 0; j < nums[i].length();j++) {
				char num = nums[i].charAt(j);
				int numint = mapper.get(num);
				int finals = numint * (int)(Math.pow(10, nums[i].length()-1-j));
				rowNum+=finals;
			}
			total+=rowNum;
		}
		System.out.println(total);
	}
}
