public class Day23 {
    public static int coinChange(int coins[], int amount) {
        int n = coins.length;

        int dp[][] = new int[n+1][amount+1];

        //initialize sum = 0 column
        // i is for coins index
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        //initialize 0 coins row
        // j is for amount
        for(int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }

        //filling the dp array
        for(int i =1; i<= n; i++){
            for(int j = 1; j<=amount; j++){
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j - coins[ i - 1]] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount];
     }
    public static void main(String[] args) {
        int coins[] = {1,2,3};
        int amount = 4;
        System.out.println(coinChange(coins, amount));
    }
}