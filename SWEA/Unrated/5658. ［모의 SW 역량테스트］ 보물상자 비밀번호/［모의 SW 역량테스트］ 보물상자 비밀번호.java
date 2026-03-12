
import java.util.*;


import java.io.*;
class Solution
{
    static int n,k;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)  {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	n= Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	String input = br.readLine();
        	int cut = input.length()/4;
        	Set<String> ss =new HashSet<>();
        	for(int i = 0; i < cut; i++) {
        		StringBuilder sb = new StringBuilder();
        		for(int j = 0; j < input.length(); j++) {
        			int idx = (j+i)%input.length();
        			sb.append(input.charAt(idx));
        			if(sb.length() == cut) {
        				ss.add(sb.toString());
        				sb.setLength(0);
        			}
        		}
        	}
        	List<String> sl = new ArrayList<String>(ss);
        	List<Integer> nums = new ArrayList<Integer>();
        	for(String s : sl) {
        		nums.add(convert(s));
        	}
        	Collections.sort(nums,(a,b)->b-a);
        	System.out.println("#"+test_case+" "+nums.get(k-1));
        }
    }
    
    static int convert(String num) {
    	int ret = 0;
    	for(int i = num.length()-1; i >=0; i--) {
    		char c = num.charAt(i);
    		int offset = (int)Math.pow(16, num.length() -i -1);
    		int val = Character.getNumericValue(c);
    		ret += val * offset;
    	}
    	return ret;
    }
}