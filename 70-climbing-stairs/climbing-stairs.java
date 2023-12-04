class Solution {
    public int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;
        int currWays = 1;
        for(int i=2;i<=n;i++)
        {
            currWays = prev1+prev2;
            prev1 = prev2;
            prev2 = currWays;
        }
        return currWays;
    }
}