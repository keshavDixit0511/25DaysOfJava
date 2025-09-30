import java.util.Arrays;

public class Day22 {
     public static int fib(int n, int[] dp) {
        if (n <= 1)  {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);

        return dp[n];
    }

    public static int fibTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10; // Example input
        int[] dp = new int[n + 1]; // Array to store intermediate results. N + 1 because we want to include n.

        Arrays.fill(dp, -1); // Initialize the array with -1 to indicate uncomputed values.

        System.out.println(fib(n, dp));
        System.out.println(fibTab(n));
    }
}
