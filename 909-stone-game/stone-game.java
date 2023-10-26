class Solution {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        //stores difference of score
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i] = piles[i];
        for(int len = 2;len <=n ; len++)
        {
            for(int i = 0; i < n - len + 1; i++)
            {
                int j = i + len - 1;
                dp[i][j] = Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
            }
        }
        if(dp[0][n-1] > 0) return true;
        return false;
    }
















/*
    public int helper(int[] piles,int totsum,int i,int j,int[][] memo) {
        if(memo[i][j]!=0) return memo[i][j];
        if(i==j)
        {
            memo[i][j] = piles[i];
            return memo[i][j];
        }
        int currsum = Math.max(totsum - helper(piles,totsum-piles[i],i+1,j,memo) + piles[i], totsum = helper(piles,totsum-piles[j],i,j-1,memo) + piles[j]);
        memo[i][j] = currsum;
        return currsum;
    }

    public boolean stoneGame(int[] piles) {
        int totsum = 0;
        int n = piles.length;
        int[][] memo = new int[n][n];
        for(int x : piles) totsum+=x;
        int asum = helper(piles,totsum,0,n-1,memo);
        if(asum >= (totsum+1)/2) return true;
        return false;
    }
*/
}