import java.util.*;

class MMC {
    static int sol(int a[], int n) {

        int m[][] = new int[n][n];

        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                if (j == n) {
                    continue;
                }
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + a[i - 1] * a[k] * a[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }
        return m[1][n - 1];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number 1d matrix");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter size of each matrix");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Minimum number of multiplications is " + sol(a, n));
    }
}
