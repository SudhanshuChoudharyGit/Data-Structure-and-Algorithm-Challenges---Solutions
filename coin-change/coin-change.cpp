class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        vector<int> dp(amount+1,-1);
        sort(coins.begin(),coins.end());
        dp[0]=0;

        int i=1;
        while(i<=amount)
        {
            int change=INT_MAX;
            for(int j=0;j<coins.size();j++)
            {
                if(i<coins[j]) break;
                if(dp[i-coins[j]]==-1) continue;
                change=min(change,dp[i-coins[j]]+1);
            }
            if(change!=INT_MAX) dp[i]=change;
            i++;
        }
        return dp[amount];


        /*
        
        vector<int> v(amount+1,-1);

        sort(coins.begin(),coins.end());

        int n=coins.size();

        v[0]=0;

        for(int i=1;i<=amount;i++)
        {
            int j=0;
            int x=INT_MAX;
            while(j<n && i>=coins[j])
            {
                if(v[i-coins[j]]!=-1)
                {
                    x=min(x,v[i-coins[j]]+1);
                }
                j++;
            }
            if(x!=INT_MAX) v[i]=x;
        }

        return v[amount];

        */
    }
};