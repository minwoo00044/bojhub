

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<String> commands;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean end = false;
		while(true) {
			commands = new ArrayList();
			while(true) {
				String command = br.readLine();
				if(command.equals("END")) break;
				else if(command.equals("QUIT")) {
					end = true;
					break;
				}
				commands.add(command);
			}
			if(end) break;
			int n = Integer.parseInt(br.readLine());
			Queue<Long> starts = new ArrayDeque<>();
			for(int i = 0 ; i < n; i++) {
				starts.add(Long.parseLong(br.readLine()));
			}
			while(!starts.isEmpty()) {
				Long start = starts.poll();
				Long res = cal(start);
				if(res > Math.pow(10, 9)||Math.abs(res) > Math.pow(10, 9))
					System.out.println("ERROR");
				else
					System.out.println(res);
			}
			System.out.println();
		}

		
	}
	static long cal(long start) {
		List<Long> list = new ArrayList<>();
		list.add(start);
		for(int i = 0; i < commands.size(); i++) {
			switch (commands.get(i)) {
			case "POP":
				if(list.size() < 1) return Long.MAX_VALUE;
				list.remove(list.size()-1);
				break;
			case "INV":
				if(list.size() < 1)  return Long.MAX_VALUE;
				list.set(list.size()-1, list.get(list.size()-1) * -1);
				break;
			case "DUP":
				if(list.size() < 1)  return Long.MAX_VALUE;
				list.add(list.get(list.size()-1));
				break;
			case "SWP":
				if(list.size() < 2) return Long.MAX_VALUE;
				long last = list.get(list.size()-1);
				list.set(list.size()-1, list.get(list.size()-2));
				list.set(list.size()-2, last);
				break;
			case"ADD":
				if(list.size() < 2)  return Long.MAX_VALUE;
				list.set(list.size()-2, list.get(list.size()-1)+list.get(list.size()-2));
				list.remove(list.size()-1);
				if(Math.abs(list.get(list.size()-1))  > 1000000000) return Long.MAX_VALUE;

				break;
			case"SUB":
				if(list.size() < 2)  return Long.MAX_VALUE;

				list.set(list.size()-2, list.get(list.size()-2)-list.get(list.size()-1));
				list.remove(list.size()-1);
				break;
			case"MUL":
				if(list.size() < 2) return Long.MAX_VALUE;

				list.set(list.size()-2, list.get(list.size()-2)*list.get(list.size()-1));
				list.remove(list.size()-1);
				if(Math.abs(list.get(list.size()-1))  > 1000000000) return Long.MAX_VALUE;

				break;
			case"DIV":
				if(list.size() < 2)  return Long.MAX_VALUE;
				int minusCnt = 0;

				long divined = Math.abs(list.get(list.size()-2));
				long divisor = Math.abs(list.get(list.size()-1));
				if(divisor == 0)  return Long.MAX_VALUE;
				if(list.get(list.size()-2) < 0)minusCnt++;
				if(list.get(list.size()-1) < 0)minusCnt++;
				long result = divined/divisor;
				if(minusCnt == 1) result*=-1;
				list.set(list.size()-2, result);
				list.remove(list.size()-1);
				break;
			case"MOD":
				if(list.size() < 2)  return Long.MAX_VALUE;
				long divisor1 = Math.abs(list.get(list.size()-1));
				if(divisor1 == 0)  return Long.MAX_VALUE;
				list.set(list.size()-2, list.get(list.size()-2) % list.get(list.size()-1));
				list.remove(list.size()-1);
				break;
			default:
				String[] row = commands.get(i).split(" ");
				if(row.length < 2) break;
				long val = Long.parseLong(row[1]);
				list.add(val);
				break;
			}
		}
		if(list.size() != 1) return Long.MAX_VALUE;
		return list.get(0);
	}
}