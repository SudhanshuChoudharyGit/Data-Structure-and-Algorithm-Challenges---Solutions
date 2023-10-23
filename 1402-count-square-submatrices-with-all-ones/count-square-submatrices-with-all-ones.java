

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int count = 0;
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    if(matrix[i-1][j-1]==0) dp[i][j] = 0;
                    else
                    {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    }
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}