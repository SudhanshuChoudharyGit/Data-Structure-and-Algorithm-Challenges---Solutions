class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        
        int[][] dp= new int[2][n];

        for(int j=0;j<n;j++) dp[1][j]=triangle.get(n-1).get(j);

        for(int level=n-2;level>=0;level--)
        {
            for(int i=0;i<=level;i++)
            {
                dp[0][i]= Math.min(dp[1][i],dp[1][i+1])+triangle.get(level).get(i);
            }
            for(int i=0;i<=level;i++) dp[1][i]=dp[0][i];
        }
        return dp[1][0];

    }
}