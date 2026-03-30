
import java.util.*;
import java.io.*;

public class Main {
	static class MyHeap {
		public MyHeap() {
			super();
			list = new ArrayList<Integer>();
			list.add(0);
		}

		List<Integer> list;

		public int index = 0;

		public void insert(int val) {
			index++;
			if(index >= list.size()) {
				list.add(val);
			}else {
				list.set(index, val);
			}
			
			int idx = index;
			if (idx == 1)
				return;

			while (list.get(idx / 2) > val) {
				int tmp = list.get(idx / 2);
				list.set(idx / 2, val);
				list.set(idx, tmp);
				idx /= 2;
				if (idx == 1)
					break;
			}
		}

		public int remove() {
			if(index == 0) return 0;
			int ret = list.get(1);
			list.set(1,list.get(index));
			index--;
			int idx = 1;
			int node = list.get(1);
			while (idx * 2 <= index) {
				int left = idx *2;
				int right = idx *2 +1;
				int smaller = left;
								

				int leftVal = list.get(left);
				int rightVal = list.get(right);
				if(right <= index && rightVal < leftVal){
					smaller = right;
				}
				if(node <= list.get(smaller)) {
					break;
				}
				list.set(idx, list.get(smaller));
				list.set(smaller, node);
				idx = smaller;
			}
			return ret;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MyHeap h = new MyHeap();
		for(int i = 0; i  < n; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if(cmd == 0) {
				System.out.println(h.remove());
			} else {
				h.insert(cmd);
			}
		}
	}
}