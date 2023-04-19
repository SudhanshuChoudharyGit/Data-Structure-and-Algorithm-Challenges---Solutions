class Solution {
public:

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

    string longestPalindrome(string s) {
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
                if(j-i==1) dp[i][j]=true;
                else
                {
                    if(dp[i+1][j-1]==true) dp[i][j]=true;
                    else dp[i][j]=false;
                }
            }
            else dp[i][j]=false;
            if(dp[i][j])
            {
                if(j-i+1>max_len)
                {
                    max_len=j-i+1;
                    ans=s.substr(i,j-i+1);
                }    
            }
        }
    }
    return ans;
    }

};