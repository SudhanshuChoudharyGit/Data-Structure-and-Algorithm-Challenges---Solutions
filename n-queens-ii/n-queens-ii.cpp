class Solution {
public:

    void fun(vector<vector<bool>> dp,int n,int i,int j,int& ans)
    {
        if(i==n-1)
        {
            ans++;
            return;
        }
        for(int ic=i+1;ic<n;ic++)
        {
            for(int jc=0;jc<n;jc++)
            {
                if(jc==j || (i-j)==(ic-jc) || (i+j)==(ic+jc)) dp[ic][jc]=false;
            }
        }
        for(int jc=0;jc<n;jc++) if(dp[i+1][jc]==true) fun(dp,n,i+1,jc,ans);
    }

    int totalNQueens(int n) {
        int ans=0;
        vector<vector<bool>> dp(n,vector<bool>(n,true));
        for(int j=0;j<n;j++)
        {
            fun(dp,n,0,j,ans);
        }
        return ans;
    }
};