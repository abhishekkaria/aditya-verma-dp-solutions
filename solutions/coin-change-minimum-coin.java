class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        if(n == 1 && amount == coins[0]) return 1;
        else if(n == 1 && amount > coins[0]) return -1; 
        else if(n == 1 && amount < coins[0]) return 0; 

        int dp[][] = new int[n+1][amount+1];

        for(int i=0 ; i<amount+1 ; i++)
            dp[0][i] = Integer.MAX_VALUE;        

        for(int i=1 ; i<n+1 ; i++)
            dp[i][0] = 0;

        for(int j=1 ; j<amount+1 ; j++)
        {
            if(j % coins[1] == 0)
                dp[1][j] = j / coins[1];
            else    
                dp[1][j] = Integer.MAX_VALUE;
        }
            
        for(int i=1 ; i<n+1 ; i++)
        {
            for(int j=1 ; j<amount+1 ; j++)
            {
                if(coins[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(dp[i][j - coins[i-1]] + 1 , dp[i-1][j]);
            }
        }

        return dp[n][amount];
    }
}