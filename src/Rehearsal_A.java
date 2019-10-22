import java.util.Arrays;
import java.util.Scanner;

 /*Rehearsal Problem A . Programming Contest Strategy */

public class Rehearsal_A {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(), CASE = 1;

        while (T-- > 0) {


            int N = sc.nextInt(), L = sc.nextInt();
            int[] cps = new int[N];


            for (int i = 0; i < N; i++)
                cps[i] = sc.nextInt();

            System.out.println("Case " + (CASE++) + ":");
            solve(cps, L);

        }

        sc.close();
    }


    static void solve(int[] cps, int L) {
        Arrays.sort(cps);

        int total = 0, count = 0, last = 0, temp = 0;

        for (int i = 0; i < cps.length; i++) {

            temp += cps[i];

            if (temp <= L) {
                count++;
                last = temp;
                total += last;
            } else
                break;
        }

        System.out.println(count + " " + last + " " + total);

    }

}

