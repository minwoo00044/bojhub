import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        HashMap<String, Double> m = new HashMap<>();
        double total = 0;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
        	if(m.containsKey(input)) {
        		m.replace(input, m.get(input)+1);
        	} else {
        		m.put(input, 1.0);
        	}
        	total++;
        }
        Set<String> s =  m.keySet();
        List<String> l = new ArrayList<String>(s);

        Collections.sort(l);
        
        for(String name : l) {
        	String format = String.format("%.4f", (m.get(name)/total)*100);
        	System.out.println(name +" "+ format);
        }
        
    }
}