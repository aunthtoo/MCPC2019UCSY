import java.util.Arrays;
import java.util.Scanner;

/*Problem H: Alphabet Frequency*/

public class H {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();

            if (N == 0)
                break;

            String S = sc.next();

            Alphabet[] alphabets = new Alphabet[26];

            for (int i = 0; i < 26; i++)
                alphabets[i] = new Alphabet((char) (i + 'a'), 0);

            for (int i = 0; i < N; i++) {
                char ch = S.charAt(i);
                Alphabet alphabet = alphabets[ch - 'a'];
                alphabets[ch - 'a'] = new Alphabet(ch, alphabet.count + 1);
            }

            Arrays.sort(alphabets);

            for (int i = 0; i < 26; i++) {
                Alphabet alphabet = alphabets[i];

                if (alphabet.count > 0) {

                    for (int j = 0; j < alphabet.count; j++) {
                        System.out.print(alphabet.ch);
                    }
                }
            }

            System.out.println();

        }
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
