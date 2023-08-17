class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> ans;
        int lenP = p.length();
        int lenS = s.length();
        if(lenS < lenP) return ans;
        int l,r;
        l=r=0;
        vector<int> freqS(26,0);
        vector<int> freqP(26,0);
        for(auto c : p)
        {
            freqP[c-'a']++;
        }
        while(r < lenS)
        {
            freqS[s[r]-'a']++;
            while(l<=r && freqS[s[r]-'a'] > freqP[s[r]-'a'])
            {
                freqS[s[l]-'a']--;
                l++;
            }
            if(r-l+1 == lenP)
            {
                ans.push_back(l);
                freqS[s[l]-'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
};