class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1) - 'a' + 97;
                dp[i][j] = Math.max(Math.max(dp[i-1][j],dp[i][j-1]),dp[i][j]);
            }
        }

        int sum1 = 0;
        for(char ch : s1.toCharArray()) sum1 += ch - 'a' + 97;
        int sum2 = 0;
        for(char ch : s2.toCharArray()) sum2 += ch - 'a' + 97;

        return sum1 + sum2 - 2*dp[m][n];

    }
}