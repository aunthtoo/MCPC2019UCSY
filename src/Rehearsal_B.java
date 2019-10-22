import java.util.Scanner;

/*Rehearsal Problem B. Fixed Password*/

public class Rehearsal_B {

    static int correctpass = 123321;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            System.out.println(sc.nextInt() == correctpass ? "Hello MCPC 2019" : "Try Again");
        }

        sc.close();
    }
}
