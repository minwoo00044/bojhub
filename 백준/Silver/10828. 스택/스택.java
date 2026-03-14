import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> s = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				s.push(Integer.parseInt(st.nextToken()));
			} else if(cmd.equals("pop")) {
				if(s.isEmpty()) System.out.println(-1);
				else System.out.println(s.pop());
			} else if(cmd.equals("size")) {
				System.out.println(s.size());
			}else if(cmd.equals("empty")) {
				String out = s.isEmpty()? "1" : "0";
				System.out.println(out);
			} else if(cmd.equals("top")) {
				if(s.isEmpty()) System.out.println(-1);
				else System.out.println(s.peek());
			}
		}
	}
}