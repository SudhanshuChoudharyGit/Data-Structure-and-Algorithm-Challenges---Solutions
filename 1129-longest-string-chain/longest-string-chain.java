class Solution {

    public boolean isPred(String big, String small){
        for(int i=0;i<big.length();i++)
        {
            String curr = big.substring(0,i) + big.substring(i+1,big.length());
            if(curr.equals(small)) return true;
        }
        return false;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int ans = 1;
        Arrays.sort(words,Comparator.comparing(a -> a.length()));
        for(int i=0;i<n;i++)
        {
            String word = words[i];
            for(int j=i-1;j>=0;j--)
            {
                String currword = words[j];
                if(currword.length()+1 < word.length()) break;
                if(currword.length()+1 > word.length()) continue;
                else
                {
                    if(isPred(word,currword)==true) dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}