class Solution {
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        int max_money = (n==0?0:nums[0]);
        int second_last=0;
        int last=max_money;
        for(int i=1;i<n;i++)
        {
            max_money=max(last,second_last+nums[i]);
            second_last=last;
            last=max_money;
        }
        return max_money;


































        /*vector<int> dp(n+1,0);
        dp[1]=nums[0];
        for(int i=2;i<=n;i++)
        {
            dp[i]=max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
        */
        /*
        int prev=nums[0];
        int ans=prev;
        int bprev=0;
        int i=1;
        while(i<n)
        {
            ans=max(prev,nums[i]+bprev);
            bprev=prev;
            prev=ans;
            i++;
        }
        return ans;
        */
    }
};