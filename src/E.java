import java.util.HashSet;
import java.util.Scanner;

/*Problem E: ICPC University Ranking*/


public class E {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        HashSet<String> unidata = new HashSet<>();

        while (N-- > 0) {

            String str = sc.nextLine();
            String uniname = str.split(" ")[0], teamname = str.substring(str.indexOf(" ") + 1);

            if (!unidata.contains(uniname)) {
                System.out.println(uniname + " " + teamname);
                unidata.add(uniname);
            }

        }

    }
}
