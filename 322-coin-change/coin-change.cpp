class Solution {
public:

    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(),coins.end());
        vector<long> dp(amount+1,(long)INT_MAX+1); 
        dp[0]=0;
        for(long sum=1;sum<=amount;sum++)
        {
            for(auto coin : coins)
            {
                if(coin>sum) break;

                if(dp[sum-coin]!=(long)INT_MAX+1)
                {
                    dp[sum] = min(dp[sum],dp[sum-coin]+1);
                }

            }
        }
        return (dp[amount]==(long)INT_MAX+1)?-1:(int)dp[amount];
    }






/*
    //backtrack with memo - Top Down
    long backtrack(vector<int>& coins,long amount,long sum,vector<long>& memo)
    {
        if(memo[sum]!=-1) return memo[sum];
        if(amount==sum) return 0;
        long usedCoins=INT_MAX;
        for(int coin : coins)
        {
            if((long)(sum+coin)>amount) break;
            usedCoins = min(usedCoins,backtrack(coins,amount,sum+coin,memo)+1);
        }
        memo[sum]=usedCoins;
        return usedCoins;
    }

    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(),coins.end());
        vector<long> memo(amount+1,-1);
        long ans = backtrack(coins,amount,0l,memo);
        return (ans==INT_MAX) ? -1 : (int)ans;
    }

*/





























    // int coinChange(vector<int>& coins, int amount) {

    //     vector<int> v(amount+1,-1);

    //     sort(coins.begin(),coins.end());

    //     int n=coins.size();

    //     v[0]=0;

    //     for(int i=1;i<=amount;i++)
    //     {
    //         int j=0;
    //         int x=INT_MAX;
    //         while(j<n && i>=coins[j])
    //         {
    //             if(v[i-coins[j]]!=-1)
    //             {
    //                 x=min(x,v[i-coins[j]]+1);
    //             }
    //             j++;
    //         }
    //         if(x!=INT_MAX) v[i]=x;
    //     }

    //     return v[amount];

    // }
/*
    // approach - Backtracking
    int backtrack(int amount, vector<int>& coins,vector<int>& memo) {
        if(amount == 0) return 0;
        if(memo[amount]!=-1) return memo[amount];
        int ans = INT_MAX;
        for(auto coin : coins)
        {
            if(coin > amount) continue;
            int ret = backtrack(amount - coin, coins,memo);
            if(ret!=INT_MAX)
            {
                ans = min(ans, ret + 1);
                break;
            }
        }
        memo[amount]=ans;
        return ans;
    }

    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(),coins.end(),greater<int> ()); //descending order
        vector<int> memo(amount+1,-1);
        memo[0]=0;
        int ans = backtrack(amount,coins,memo);
        return (ans==INT_MAX) ? -1 : ans ;
    }
*/
};