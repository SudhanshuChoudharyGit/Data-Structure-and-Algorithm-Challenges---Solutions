class Solution {
    long MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n+1][target+1];

        dp[0][0] = 1;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                for(int num = 1;num<=k;num++)
                {
                    if(j>=num) dp[i][j] = (dp[i][j]%MOD + dp[i-1][j-num]%MOD)%MOD;
                }
            }
        }

        return (int)dp[n][target];
    }
}