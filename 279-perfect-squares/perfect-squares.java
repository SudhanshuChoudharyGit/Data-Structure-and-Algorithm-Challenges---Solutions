class Solution {


    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for(int i=1;i*i<=n;i++)
        {
            int curr = i*i;
            for(int j=curr;j<=n;j++)
            {
                dp[j]=  Math.min(dp[j],dp[j-curr]+1);
            }
        }

        return dp[n];
    }
}