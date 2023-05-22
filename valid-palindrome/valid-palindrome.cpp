class Solution {
public:
    bool isPalindrome(string s) {
        string str="";
        for(char c : s)
        {
            if(c>='a' && c<='z' || c>='A' && c<='Z' || c>='0' && c<='9')
            {
                str+=tolower(c);
            }
        }
        int n=str.length();
        for(int i=0;i<n/2;i++)
        {
            if(str[i]!=str[n-i-1]) return false;
        }
        return true;
    }
};