import java.util.Arrays;
import java.util.Scanner;

/*Problem H: Alphabet Frequency
  Time Complexity : O(n)
  Space Complexity: O(1)
  where n is the length of string
*/

public class H {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        while (N>0) {

            String S = sc.next();

            Alphabet[] alphabets = new Alphabet[26];

            for (int i = 0; i < 26; i++)
                alphabets[i] = new Alphabet((char) (i + 'a'), 0);

            for (char ch: S.toCharArray()) {
                alphabets[ch - 'a'].count++;
            }

            Arrays.sort(alphabets);
            
            for (int i = 0; i < 26; i++) {
                
               Alphabet alphabet = alphabets[i];

                if (alphabet.count > 0) {

                    for (int j = 0; j < alphabet.count; j++) {
                        sb.append(alphabet.ch);
                    }
                }
            }

            sb.append("\n");
            N = sc.nextInt();
        }
        System.out.println(sb.toString());
    }

    static class Alphabet implements Comparable<Alphabet> {
        private char ch;
        private int count;

        public Alphabet(char ch, int count) {
            super();
            this.ch = ch;
            this.count = count;
        }
        
        @Override
        public int compareTo(Alphabet o) {
            if (this.count < o.count)
                return -1;
            else if (this.count > o.count)
                return 1;
            else {
                if (this.ch > o.ch)
                    return -1;
                else
                    return 1;
            }
        }
    }
}
