import java.util.Scanner;
import java.util.Stack;

/*Problem B: Brace Matching*/

public class B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String input = sc.next();

            Stack<Character> characters = new Stack<>();

            boolean b = true;

            for (int i = 0; i < input.length(); i++) {

                char ch = input.charAt(i);

                if (ch == '(')
                    characters.add(ch);
                else if (ch == '{')
                    characters.add(ch);
                else if (ch == '[')
                    characters.add(ch);
                else if (ch == ')') {

                    if (!characters.isEmpty()) {

                        if (characters.pop() != '(') {
                            b = false;
                            break;
                        }

                    } else {
                        b = false;
                        break;
                    }
                } else if (ch == '}') {
                    if (!characters.isEmpty()) {

                        if (characters.pop() != '{') {
                            b = false;
                            break;
                        }

                    } else {
                        b = false;
                        break;
                    }

                } else if (ch == ']') {
                    if (!characters.isEmpty()) {

                        if (characters.pop() != '[') {
                            b = false;
                            break;
                        }

                    } else {
                        b = false;
                        break;
                    }
                }
            }


            if (!b || !characters.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
