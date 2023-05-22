class Solution {
public:

int lengthOfLongestSubstring(string s) {
    int n=s.length();
    if(n==0 || n==1) return n;
    vector<int> freq(256,-1);
    int i=0;
    int j=0;
    int maxlen=1;
    int len=0;
    while(j<n)
    {
        if(freq[s[j]]==-1)
        {
            freq[s[j]]=j;
            len++;
        }
        else
        {
            int newi = freq[s[j]]+1;
            for(int index=i;index<newi;index++) freq[s[index]]=-1;
            i = newi;
            freq[s[j]]=j;
            len=j-i+1;
        }
        j++;
        maxlen=max(maxlen,len);
    }
    return maxlen;
}

































/*
    int lengthOfLongestSubstring(string s) {
        vector<int> v(128,-1);

        int curr_len=0;
        int max_len=0;
        int l=0;

        for(int i=0;i<s.length();i++)
        {
            if(v[s[i]]==-1) 
            {
                curr_len+=1;
            }
            else
            {
                int x=max(l,v[s[i]]);
                curr_len=i-x;
                l=x;
            }
            v[s[i]]=i;
            max_len=max(max_len,curr_len);
        }
        return max_len;
    }
*/
};