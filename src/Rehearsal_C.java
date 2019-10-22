import java.util.Scanner;

/*Rehearsal Problem C. Right Triangle*/

public class Rehearsal_C {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

            if (a >= b && a >= c) {
                System.out.println(Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2) ? 1 : 0);
            } else if (b >= a && b >= c) {
                System.out.println(Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2) ? 1 : 0);
            } else {
                System.out.println(Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2) ? 1 : 0);
            }
        }

        sc.close();
    }
}
