import java.util.Scanner;

/*Problem I: Hand Game*/

public class I {

    public static void main(String[] args) {

        String[][] dataset = {
                {"tie", "B", "A", "A", "B"},
                {"A", "tie", "B", "B", "A"},
                {"B", "A", "tie", "A", "B"},
                {"B", "A", "B", "tie", "A"},
                {"A", "B", "A", "B", "tie"}
        };

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            String playerA = sc.next(), playerB = sc.next();

            int countA = 0, countB = 0;

            for (int i = 0; i < playerA.length(); i++) {
                int idx1 = playerA.charAt(i) - '0', idx2 = playerB.charAt(i) - '0';

                if (isValid(idx1, idx2)) {
                    if (dataset[idx1][idx2].equals("A"))
                        countA++;
                    else if (dataset[idx1][idx2].equals("B"))
                        countB++;

                }

            }

            if (countA > countB) {
                System.out.println("Winner is Player A!");
                System.out.println("Win=" + countA);
            } else if (countB > countA) {
                System.out.println("Winner is Player B!");
                System.out.println("Win=" + countB);
            } else {
                System.out.println("It is tie!");
            }
        }
    }

    static boolean isValid(int i, int j) {
        return i >= 0 && i < 5 && j >= 0 && j < 5;
    }
}
