class Solution {
public:

int lengthOfLongestSubstring(string s) {
    int n=s.length();
    if(n==0 || n==1) return n;
    set<char> currchars;
    int maxlen=0;
    int left=0;
    for(int right=0;right<n;right++)
    {
        while(currchars.count(s[right])!=0)
        {
            currchars.erase(s[left]);
            left++;
        }
        currchars.insert(s[right]);
        int currlen=currchars.size();
        maxlen=max(maxlen,currlen);
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