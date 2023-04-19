class Solution {
public:

    string fun(string s, int l,int r,int n)
    {
        while(l>=0 && r<=n-1)
        {
            if(s[l]!=s[r]) break;
            l--;
            r++;
        }
        l++;
        r--;
        return s.substr(l,r-l+1);

    }

    string longestPalindrome(string s) {
        string ans=s.substr(0,1);
        int n=s.length();
        int max_len=1;
        for(int i=0;i<n-1;i++)
        {
            string str=fun(s,i,i,n);
            if(str.length()>max_len) 
            {
                max_len=str.length();
                ans=str;
            }
            if(s[i]==s[i+1]) 
            str=fun(s,i,i+1,n);
            if(str.length()>max_len) 
            {
                max_len=str.length();
                ans=str;
            }
        }
        return ans;
    }
};