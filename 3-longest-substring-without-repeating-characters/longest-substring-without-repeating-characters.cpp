class Solution {
public:
    //sliding window
    int lengthOfLongestSubstring(string s) {
        int len = s.length();
        if(!len) return 0;
        int ans=0;
        int l,r;
        l=r=0;
        vector<int> freq(256,0);
        while(r<len)
        {
            freq[s[r]]++;
            while(l<=r && freq[s[r]]>1)
            {
                freq[s[l]]--;
                l++;
            }
            ans = max(ans,r-l+1);
            r++;
        }
    return ans;
    }
};