class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        int maxlength=1;
        vector<int> dp(n,1);
        for(int i=1;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[j]<nums[i] && dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                    maxlength=max(maxlength,dp[i]);
                }
            }
        }
        return maxlength;
    }
};