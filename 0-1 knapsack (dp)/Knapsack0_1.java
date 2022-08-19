import java.util.*;

public class Knapsack0_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of values");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter Values: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int wt[] = new int[n];
        System.out.println("Enter Weights: ");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter Capacity");
        int c = sc.nextInt();
        System.out.println("Result: " + knapsack(a, wt, n, c));
    }

    static int knapsack(int a[], int wt[], int n, int c) {
        int dp[][] = new int[n + 1][c + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < c + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return knapsack2(dp, a, wt, n, c);
    }

    static int knapsack2(int dp[][], int a[], int wt[], int n, int c) {
        if (n == 0 || c == 0) {
            return 0;
        }

        if (dp[n][c] != -1) {
            return dp[n][c];
        }

        if (wt[n - 1] > c) {
            return dp[n][c] = knapsack2(dp, a, wt, n - 1, c);
        }

        else {
            return dp[n][c] = max((a[n - 1] + knapsack2(dp, a, wt, n - 1, c - wt[n - 1])),
                    knapsack2(dp, a, wt, n - 1, c));
        }
    }

    static int max(int x, int y) {
        return (x > y) ? x : y;
    }
}
