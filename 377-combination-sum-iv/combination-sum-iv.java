class Solution {

    public int recursion(int[] nums,int target,int n,int[][] dp) {
        if(dp[n][target]!=-1) return dp[n][target];
        if(target==0) return 1;
        else if(n==0) return 0;
        dp[n][target] = 0;
        for(int i=n;i>=1;i--)
        {
            if(nums[i-1]<=target) dp[n][target] += recursion(nums,target-nums[i-1],n,dp);
        }
        return dp[n][target];
    }


    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return recursion(nums,target,n,dp);
    }
}