class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for(int x : stones) totalSum+=x;
        int target = totalSum/2;
        int n = stones.length;
        boolean[][] dp = new boolean[n+1][target+1];
        //no stones selected -> true for target = 0
        dp[0][0] = true;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(stones[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-stones[i-1]];
                }
                else dp[i][j] = dp[i-1][j];
            } 
        }

        int nearestSum=0;
        for(int j = target;j>=0;j--)
        {
            if(dp[n][j]==true)
            {
                nearestSum = j;
                break;
            }
        }

        return Math.abs(totalSum-2*nearestSum);

    }
}