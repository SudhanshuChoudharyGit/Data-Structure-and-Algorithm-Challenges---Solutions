class Solution {
    int MOD  = (int)Math.pow(10,9)+7;

    //bottom up - DP
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[n+1][m+1][k+1];
        for(int i = 1;i<=m;i++) dp[n][i][0] = 1;

        for(int a=n-1;a>=0;a--)
        {
            for(int b=m;b>=0;b--)
            {
                for(int c=0;c<=k;c++)
                {
                    for(int ind = 1;ind<=b;ind++)
                    {
                        dp[a][b][c] = (dp[a][b][c] + dp[a+1][b][c])%MOD;
                    }
                    if(c>0){for(int ind = b+1; ind<=m;ind++)
                    {
                        dp[a][b][c] = (dp[a][b][c] + dp[a+1][ind][c-1])%MOD;
                    }}
                }
            }
        }

        return dp[0][0][k]; 
    }


    //recursion with memoizartion : top-down
    /*
    public int poss(int ind, int maxSoFar, int remain,int n,int m,int[][][] memo){
        //have put too many maximums
        if(remain<0) return 0;

        //indexes are exhausted
        if(ind==n)
        {
            //current one is a possibility if we have gotten correct score
            return (remain==0) ? 1 : 0;
        }

        if(memo[ind][maxSoFar][remain]!=-1) return memo[ind][maxSoFar][remain];

        int ans = 0;

        //curr number is not next maximum 
        for(int i=1;i<=maxSoFar;i++)
        {
            ans = (ans + poss(ind+1,maxSoFar,remain,n,m,memo))%MOD;
        }

        //curr number is next maximum
        for(int i=maxSoFar+1;i<=m;i++)
        {
            ans = (ans + poss(ind+1,i,remain-1,n,m,memo))%MOD;
        }

        memo[ind][maxSoFar][remain] = ans;
        return ans;
    }

    public int numOfArrays(int n, int m, int k) {
        int maxSoFar = 0;
        int remain = k;
        int ind = 0;
        int[][][] memo = new int[n][m+1][k+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=m;j++) Arrays.fill(memo[i][j],-1);
        }
        return poss(ind,maxSoFar,remain,n,m,memo);
    }
    */
}