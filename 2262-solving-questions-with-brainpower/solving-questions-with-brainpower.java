class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        for(int i=n-1;i>=0;i--)
        {
            int skip = questions[i][1];
            int points = questions[i][0];
            dp[i] = Math.max(points+dp[Math.min(i+skip+1,n)],dp[i+1]);
        }
        return dp[0];
    }
}