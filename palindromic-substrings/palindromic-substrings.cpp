class Solution {
public:

    int fun(string s,int l,int r) {
        int count=0;
        while(l>=0 && r<s.length() && s[l]==s[r])
        {
            count++;
            l--;
            r++;
        }
        return count;
    }

    int countSubstrings(string s) {
        int n = s.length();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=fun(s,i,i);
            ans+=fun(s,i,i+1);
        }
        return ans;
    }
};