class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0) dp[i][j] = 0;
                else
                {
                    if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                    else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    /*
    //recursion
    public int recursion(String text1, String text2, int n,int m,int[][] dp){
        if(n==0 || m==0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        dp[n][m] = 0;
        if(text1.charAt(n-1)==text2.charAt(m-1)) dp[n][m] =  1 + recursion(text1,text2,n-1,m-1,dp);
        else dp[n][m] = Math.max(recursion(text1,text2,n-1,m,dp),recursion(text1,text2,n,m-1,dp));
        return dp[n][m];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return recursion(text1,text2,n,m,dp);
    }
    */
}