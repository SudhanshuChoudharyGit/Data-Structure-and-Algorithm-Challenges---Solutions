class Solution {

    //palindrome appraoch
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i] = 1;
        for(int len=2;len<=n;len++)
        {
            for(int i=0;i<n-len+1;i++)
            {
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j)) dp[i][j] = dp[i+1][j-1]+2;
                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }







    //LCS of string and reversed string
    /*
    public int longestPalindromeSubseq(String s) {
       StringBuffer sbr = new StringBuffer(s);
       sbr.reverse();
       String rev = new String(sbr);
       int n = s.length();
        int m = rev.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0) dp[i][j] = 0;
                else
                {
                    if(s.charAt(i-1)==rev.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                    else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m]; 
    }
    */
}