class Solution {
public:

    string fun(string s,int l,int r) {
        int n=s.length();
        int maxlen=0;
        string ans="";
        while(l>=0 && r<n && s[l]==s[r])
        {
            if(r-l+1 > maxlen)
            {
                maxlen=r-l+1;
                ans = s.substr(l,maxlen);
            }
            l--;
            r++;
        }
        return ans;
    }

    string longestPalindrome(string s) {
        //trying every point as the center point of possible palindrome
        //expanding till true
        //doing it for odd and even lengths both
        int n=s.length();
        int maxlen=0;
        string ans="";
        for(int i=0;i<n;i++)
        {
            string str1= fun(s,i,i);
            string str2= fun(s,i,i+1);
            int len = max(str1.length(),str2.length());
            if(len > maxlen) 
            {
                maxlen=len;
                ans = ((str1.length() > str2.length()) ? str1 : str2);
            }
        }
        return ans;
    }
};






























    //intuitive approach
    //time complexity = O(n^2) [worst case]
    /*string fun(string s, int l,int r,int n)
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

    }*/

    //string longestPalindrome(string s) {
        /*string ans=s.substr(0,1);
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
    */


    //dynamic programming
    //dp[i][j]=true if i to j is a palindrome
    /*
    int n=s.length();
    if(n==1) return s;
    string ans;
    int max_len=0;
    vector<vector<int>> dp(n,vector<int>(n,false));

    for(int i=0;i<n;i++) dp[i][i]=true;

    max_len=1;
    ans=s.substr(0,1);

    for(int i=n-1;i>=0;i--)
    {
        for(int j=i+1;j<n;j++)
        {
            if(s[i]==s[j])
            {
                if(j-i==1 || dp[i+1][j-1])
                {
                    dp[i][j]=true;
                    if(j-i+1>max_len)
                    {
                        max_len=j-i+1;
                        ans=s.substr(i,j-i+1);
                    }
                }
            }
        }
    }
    return ans;
    }
    */

