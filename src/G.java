import java.util.Scanner;

/*Problem G: Permutation of K Inversions
  Time Complexity : O(1) after everything is calculated and stored in arr
  Space Complexity: O(1)
*/

public class G {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(permuWithKthInversion(n, k));
        }
    }
    static int arr[][] = new int[100][100];
    static int permuWithKthInversion(int n, int k) {

        if (n == 0) return 0;
        if (k == 0) return 1;

        if (arr[n][k] != 0) return arr[n][k];

        int sum = 0;

        for (int i = 0; i <= k; i++) {
            if (i <= n - 1) {
                sum += permuWithKthInversion(n - 1, k - i);
            }
        }
        arr[n][k] = sum;
        return sum;
    }
}
