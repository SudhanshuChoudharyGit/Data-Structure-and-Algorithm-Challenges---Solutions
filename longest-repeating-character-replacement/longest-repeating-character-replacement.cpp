class Solution {
public:

    int maxC(vector<int>& freq)
    {
        int ans=0;
        for(int x : freq) ans=max(ans,x);
        return ans;
    }

    int characterReplacement(string s, int k) {
        int n=s.length();
        if(n==1) return 1;
        int ans=0;
        vector<int> freq(26,0);
        int l=0;
        int r=0;
        while(r<n)
        {
            freq[s[r]-'A']++;
            int maxfreq = maxC(freq);
            while((r-l+1)-maxfreq>k)
            {
                freq[s[l]-'A']--;
                l++;
                maxfreq = maxC(freq);
            }
            ans=max(ans,r-l+1);
            r++;
        }
        return ans;
    }
};