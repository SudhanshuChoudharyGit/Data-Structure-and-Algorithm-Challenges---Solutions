class Solution {

    public int count0s(String str)
    {
        int count = 0;
        for(char ch : str.toCharArray())
        {
            if(ch=='0') count++;
        }
        return count;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int i=1;i<=len;i++)
        {
            int countOf0s = count0s(strs[i-1]);
            int countOf1s = strs[i-1].length()-countOf0s;
            for(int j=0;j<=m;j++)
            {
                for(int k=0;k<=n;k++)
                {
                    if(countOf0s<=j && countOf1s<=k)
                    {
                        dp[i][j][k] = Math.max(dp[i-1][j-countOf0s][k-countOf1s]+1,dp[i-1][j][k]);
                    }
                    else dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }

        return dp[len][m][n];
    }
}