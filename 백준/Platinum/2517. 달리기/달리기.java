
import java.util.*;
import java.io.*;


public class Main {
	static class Player{
		public Player(int idx, int val) {
			super();
			this.idx = idx;
			this.val = val;
		}
		int idx,val,rank;
	}
	static int[] tree;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Player> players = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			players.add(new Player(i+1, Integer.parseInt(br.readLine())));
		}
		Collections.sort(players, (a,b)-> a.val - b.val);
		for(int i = 0; i < n; i++) {
			players.get(i).rank = n-i;
		}
		Collections.sort(players, (a,b)-> a.idx - b.idx);
		tree = new int[4 * n];
		StringBuilder sb =new StringBuilder();
		for(int i = 0; i < n; i++) {
			int cRank = players.get(i).rank;
			int betterCnt = getBetterCnt(1,1,n,1,cRank-1)+1;
			sb.append(betterCnt+"\n");
			update(1,1,n,cRank);
		}
		System.out.println(sb.toString());
	}
	private static void update(int node, int start, int end, int rank) {
		if(rank < start||rank>end) return;
		tree[node]+=1;
		if(start!=end) {
			int mid = (start+end)/2;
			update(node*2, start, mid, rank);
			update(node*2+1,mid+1,end,rank);
		}
	}
	private static int getBetterCnt(int node, int start, int end, int left,int right) {
		if(left > end || right < start) return 0;
		if(left <= start && end <= right) return tree[node];
		
		int mid = (start+end)/2;
		return getBetterCnt(node*2, start, mid, left, right)+
				getBetterCnt(node*2+1, mid+1, end, left, right);
	}
}
