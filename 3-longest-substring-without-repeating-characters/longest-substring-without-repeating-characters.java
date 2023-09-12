class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l=0;
        int r=0;
        int[] freq = new int[256];
        int ans = 0;
        while(r<n)
        {
            freq[s.charAt(r)]++;
            while(freq[s.charAt(r)]>1)
            {
                freq[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}

//time : O(n)
//space : O(1)