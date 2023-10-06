class Solution {

    //maths
    public int integerBreak(int n) {
        if(n<=3) return n-1;
        int ans = 1;
        while(n>4)
        {
            ans*=3;
            n -= 3;
        }

        return ans*n;
    }

    //dp
    /*
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=i/2;j++)
            {
                dp[i] = Math.max(dp[i],Math.max(j,dp[j])*Math.max(i-j,dp[i-j]));
            }
        }
        return dp[n];
    }
    */
}