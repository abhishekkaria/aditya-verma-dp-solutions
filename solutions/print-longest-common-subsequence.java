import java.util.ArrayList;

public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
        // Write your code here.        
        int dp[][] = new int[n+1][m+1];
        
        for(int i=1 ; i<= n ; i++)
        {
            for(int j=1 ; j<= m ; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j -1))
                    dp[i][j] = dp[i-1][j-1] + 1;                                       
                else 
                    Math.max(dp[i][j-1],  dp[i-1][j]);                
            }   
        }

        int l = dp[n][m];
        int i = n;
        int j = m;
        String s = "";

        while(i > 0 && j > 0)
        {
            if(s1.charAt(i-1) == s2.charAt(j-1))
            {
                s =  s1.charAt(i-1) + s;
                i--;
                j--;
            }
            else if(dp[i][j-1] > dp[i][j-1])            
                i--;            
            else
                j--;
        }

        return s;
    }
}