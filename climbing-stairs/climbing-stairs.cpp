class Solution {
public:
    int climbStairs(int n) {
        if(n<=2) return n;
        int dp[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        int i=3;
        while(i<=n)
        {
            dp[i]=dp[i-1]+dp[i-2];
            i++;
        }
        return dp[n];
    }
};