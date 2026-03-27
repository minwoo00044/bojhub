import java.util.*;
import java.io.*;

public class Main {
	static int n,m,k;
	static long nums[],tree[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new long[n+1];
        tree = new long[n*4];
        for(int i = 1; i < n+1 ; i++) {
        	nums[i] = Long.parseLong(br.readLine());
        }
        init(1,1,n);
        for(int i = 0; i < m+k; i++) {
        	st = new StringTokenizer(br.readLine());
        	String cmd = st.nextToken();
        	int second = Integer.parseInt(st.nextToken());
        	Long third = Long.parseLong(st.nextToken());
        	if(cmd.equals("1")) {
        		long diff  = third - nums[second] ;
        		nums[second] = third;
        		update(1,1,n,second,diff);
        	} else {
        		System.out.println(sum(1,1,n,second,(int)third.longValue()));
        	}
        }
    }
    static long init(int node, int start, int end) {
    	if(start==end) {
    		return tree[node] = nums[start];
    	}
    	int mid = (start+end)/2;
    	return tree[node]= init(node*2,start,mid) + init(node*2+1,mid+1,end);
    }
    static void update(int node, int start, int end, int index, long diff) {
    	if(index < start || index >end) return;
    	tree[node] += diff;
    	if(start != end) {
    		int mid = (start+end)/2;
    		update(node*2, start,mid, index, diff);
    		update(node*2+1, mid+1,end,index,diff);
    	}
    }
    static long sum(int node, int start, int end, int left, int right) {
    	if(left > end || right < start ) return 0;
    	if(left <= start && end <= right) return tree[node];
    	int mid = (start+end)/2;
    	return sum(node*2,start,mid,left,right) + sum (node*2+1, mid+1, end, left, right);
    }
}