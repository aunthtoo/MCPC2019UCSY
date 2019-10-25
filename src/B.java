import java.util.Scanner;
import java.util.Stack;

/*Problem B: Brace Matching
  Time Complexity : O(n)
  Space Complexity: O(n)
  where n is the length of the input
*/

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      String input = sc.next();
      if (isValid(input)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
    sc.close();
  }

  public static boolean isValid(String s) {
    Stack<Character> st = new Stack();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        st.push(')');
      } else if (c == '{') {
        st.push('}');
      } else if (c == '[') {
        st.push(']');
      } else if (c == ')' || c == '}' || c == ']') {
        if (st.isEmpty() || c != st.pop()) {
          return false;
        }
      }
    }
    if (st.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}
