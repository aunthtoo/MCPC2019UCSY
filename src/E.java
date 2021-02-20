import java.util.HashSet;
import java.util.Scanner;

/*Problem E: ICPC University Ranking
  Time Complexity : O(n)
  Space Complexity: O(n)
  where n is the total number of teams
 */

public class E {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = Integer.parseInt(sc.nextLine());

    HashSet<String> unidata = new HashSet<>();

    while (N-- > 0) {

      String str = sc.nextLine();

      int idx = str.indexOf(' ');

      String uniname = str.substring(0, idx), teamname = str.substring(idx + 1);

      if (!unidata.contains(uniname)) {
        System.out.println(str);
        unidata.add(uniname);
      }

    }
    
    sc.close();
  }
}
