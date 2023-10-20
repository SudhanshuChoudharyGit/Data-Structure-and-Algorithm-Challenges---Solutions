class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int x : nums) sum+= x;
        if(sum%2!=0) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i=1;i<=n;i++)
        {
            for(int j=target;j>=nums[i-1];j--)
            {

                dp[j] = dp[j] || dp[j-nums[i-1]];

            }
        }
        return dp[target];
    }
}