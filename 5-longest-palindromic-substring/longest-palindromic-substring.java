class Solution {

    /*
    public String helper(String s, int l,int r)
    {
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }

    public String longestPalindrome(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++)
        {
            String oddlen = helper(s,i,i);
            String evenlen = helper(s,i,i+1);
            if(Math.max(oddlen.length(),evenlen.length())>ans.length())
            ans = (oddlen.length()>evenlen.length()) ? oddlen : evenlen;
        }
        return ans;
    }
    */


    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++) dp[i][i]=true;
        String ans = "";
        ans+= s.charAt(0);
        for(int len=2;len<=n;len++)
        {
            for(int i=0;i<n-len+1;i++)
            {
                int j = i+len-1;
                if(len==2)
                {
                    if(s.charAt(i)==s.charAt(j)) dp[i][j] = true;
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true) dp[i][j] = true;
                }
                if(dp[i][j]==true && len>ans.length()) ans = s.substring(i,j+1);
            }
        }
        return ans;
    }


















    /*
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        int ind = -1;
        int maxLen = 0;
        StringBuffer sbr = new StringBuffer(s);
        sbr.reverse();
        String rev = new String(sbr);
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==rev.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(dp[i][j]>maxLen)
                {
                    maxLen = dp[i][j];
                    ind = i-1;
                }
            }
        }

        return s.substring(ind-maxLen+1,ind+1);
    }
    */
}