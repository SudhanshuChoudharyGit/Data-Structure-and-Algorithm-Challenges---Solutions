class Solution {

    public int backtrack(String s, int index,int[] memo) {
        if(memo[index]!=-1) return memo[index];
        if(index == s.length())
        {
            memo[index] = 1;
            return 1;
        }
        int poss = 0;
        String num = ""+s.charAt(index);
        if(Integer.parseInt(num)>0) poss += backtrack(s,index+1,memo);
        if(index<s.length()-1)
        {
            num += s.charAt(index+1);
            if(Integer.parseInt(num)>9 && Integer.parseInt(num)<=26)
            poss += backtrack(s,index+2,memo);
        }
        memo[index] = poss;
        return poss;
    }

    public int numDecodings(String s) {
        int[] memo = new int[s.length()+1];
        Arrays.fill(memo,-1);
        return backtrack(s,0,memo);
        //dynamic programming
        /*
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
        */
    }
}