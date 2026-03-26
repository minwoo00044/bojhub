import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Stack<Character> open = new Stack<>();
        
        long total = 0;
        int inner = 1;
        boolean isCorrect = true;

        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);

            if (c == '(') {
                open.push(c);
                inner *= 2;
            } else if (c == '[') {
                open.push(c);
                inner *= 3;
            } else if (c == ')') {
                if (open.isEmpty() || open.peek() != '(') {
                    isCorrect = false;
                    break;
                }
                if (st.charAt(i - 1) == '(') {
                    total += inner;
                }
                open.pop();
                inner /= 2;
            } else if (c == ']') {
                if (open.isEmpty() || open.peek() != '[') {
                    isCorrect = false;
                    break;
                }
                if (st.charAt(i - 1) == '[') {
                    total += inner;
                }
                open.pop();
                inner /= 3;
            }
        }

        if (!isCorrect || !open.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(total);
        }
    }
}