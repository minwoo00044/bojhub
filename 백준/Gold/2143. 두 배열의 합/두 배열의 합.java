
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Long> sumA = new ArrayList<Long>();
		List<Long> sumB = new ArrayList<Long>();
		long t = Long.parseLong(br.readLine());
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		long[] b = new long[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			Long sum = (long) 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				sumA.add(sum);
			}
		}
		for (int i = 0; i < m; i++) {
			Long sum = (long) 0;
			for (int j = i; j < m; j++) {
				sum += b[j];
				sumB.add(sum);
			}
		}
		Collections.sort(sumA);
		Collections.sort(sumB);

		int pa = 0;
		int pb = sumB.size() - 1;
		long sum = 0;
		while (pa < sumA.size() && pb >= 0) {
			long valA = sumA.get(pa);
			long valB = sumB.get(pb);
			long valSum = valA + valB;
			if (valSum == t) {
				long cntA = 0;
				while (pa < sumA.size() && sumA.get(pa) == valA) {
					cntA++;
					pa++;
				}
				long cntB = 0;
				while (pb >=0 && sumB.get(pb) == valB) {
					cntB++;
					pb--;
				}
				sum += (cntA * cntB);
			} else if(valSum < t) {
				pa++;
			}else {
				pb--;
			}
		} 
		System.out.println(sum);
	}
}