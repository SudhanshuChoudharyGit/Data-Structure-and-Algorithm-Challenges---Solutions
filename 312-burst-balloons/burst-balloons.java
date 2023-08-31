class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newarr = new int[n+2];
        newarr[0]=1;
        newarr[n+1]=1;
        for(int i=1;i<=n;i++) newarr[i]=nums[i-1];

        int[][] dp = new int[n+2][n+2];


        for(int size=1;size<=n;size++)
        {
            for(int l=1;l<=n-size+1;l++)
            {
                int r = l+size-1;
                for(int k=l;k<=r;k++)
                {
                    dp[l][r] = Math.max(dp[l][r], dp[l][k-1]+dp[k+1][r]+(newarr[l-1]*newarr[k]*newarr[r+1]));
                }
            }
        }

        return dp[1][n];
        
    }
}