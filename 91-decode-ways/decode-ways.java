class Solution {
    public int numDecodings(String s) {
        //backtracking
        // 226
        // 2 -> 26 
        // 22 -> 6
        // ---
        // 26
        // 2 -> 6
        // 26 -> ""

        // 206
        // 2 -> 06 (return)
        // 20 -> 6 -> "" -> count++
        // -1

        // 2
        // 2 -> ""
        // if(i<n-1)

        // 12
        // 1 -> 2 -> "" -> count++;
        // 12 -> "" -> count ++;
        // -2

        // --------
        //dynamic prgramming
        //226

        // [1,1,2,3]
        // dp[0] = 1
        // i (if possible)-> dp[i-1]
        // i + i-1 (if possible)-> dp[i-2]
        // dp[i] = dp[i-1] + dp[i-2]

        // 2006
        // [1,1,1,0,0]

        // 206
        // [1,1,1,1]

        // dp -> []
        // state
        // dp[i] = number of ways to decode string of length 0 to i

        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] dp = new int[n+1];
        dp[0] = 1;
        if(ch[0]!='0') dp[1] = 1;
        for(int i=2;i<=n;i++)
        {
            String num = "";
            num += ch[i-1];
            if(Integer.parseInt(num)>0) dp[i]+=dp[i-1];
            num = ch[i-2] + num;
            if(Integer.parseInt(num)>9 && Integer.parseInt(num)<=26) dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}