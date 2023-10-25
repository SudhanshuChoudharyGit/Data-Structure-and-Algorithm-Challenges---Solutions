class Solution {
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
}