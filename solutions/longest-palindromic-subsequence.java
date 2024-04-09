class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        int n = S.length();
        int m = n;
        String s1 = "";

        for(int i=n-1 ; i>=0 ; i--)        
            s1 = s1 + S.charAt(i);
        
        int dp[][] = new int[n+1][m+1];
        
        for(int i=1 ; i<=n ; i++)
        {
            for(int j=1 ; j<=m ; j++)
            {
                if(S.charAt(i-1) == s1.charAt(j-1))                
                    dp[i][j] = dp[i-1][j-1] + 1;                                                     
                else 
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }    
        }
 
        return dp[n][m];
    }
}