class Solution {
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;

        int ans = 0;

        boolean[][] dp = new boolean[n][n];

        for(int i=0;i<n;i++) dp[i][i]=true;
        ans+=n;

        for(int size=2;size<=n;size++)
        {
            for(int l=0;l<=n-size;l++)
            {
                int r = l+size-1;
                if(size==2)
                {
                    if(ch[l]==ch[r]) dp[l][r]=true;
                }
                else
                {
                    if(dp[l+1][r-1]==true && ch[l]==ch[r]) dp[l][r]=true;
                }
                if(dp[l][r]==true) ans++;
            }
        }
        return ans;
    }
}