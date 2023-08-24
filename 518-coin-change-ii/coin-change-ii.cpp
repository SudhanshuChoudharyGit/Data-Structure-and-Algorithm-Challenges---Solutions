class Solution {
public:

    int backtrack(int amount,vector<int>& coins,int sum,int index,vector<vector<int>>& dp) {
        if(dp[sum][index]!=-1) return dp[sum][index];
        if(sum==amount) return 1;
        int ans=0;
        for(int i=index;i<coins.size();i++)
        {
            if(sum+coins[i]>amount) break;
            ans+=backtrack(amount,coins,sum+coins[i],i,dp);
        }
        dp[sum][index]=ans;
        return ans;
    }

    int change(int amount, vector<int>& coins) {
        sort(coins.begin(),coins.end());
        vector<vector<int>> dp(amount+1,vector<int>(coins.size(),-1));
        return backtrack(amount,coins,0,0,dp);
    }
};