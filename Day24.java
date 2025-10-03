import java.util.Arrays;

public class Day24 {

    // 0-1 Knapsack Problem

    public static int knapsack(int[] val, int[] wt, int W, int n, int[][] dp) {
        // base case
        if(n == 0 || W == 0) return 0;

        if(dp[n][W] != -1) return dp[n][W];


        if(wt[n-1] <= W) { // valid
            //include
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsack(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];

        }else{ // not valid
            dp[n][W] = knapsack(val, wt, W, n-1, dp);
            return dp[n][W];
        }

        
    }

    public static int knapsackTab(int[] val, int[] wt, int W, int n){
        int dp[][] = new int[n+1][W+1];

        //base case
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= W; j++){
            dp[0][j] = 0;
        }


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                int value = val[i-1];
                int weight = wt[i-1];

                if (weight <= j) {
                    int incProfit = value + dp[i-1][j-weight];
                    int excProfit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    
    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;
        int n = val.length;

        int dp[][] = new int[n+1][W+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        // System.out.println(knapsack(val, wt, W, n, dp));
        System.out.println(knapsackTab(val, wt, W, n));
    }
}
