class Solution {
public:
    bool isPalindrome(string s) {

        //making new string with only alnum
        /*string str="";
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
        */

        //using isalnum function
        int n=s.length();
        int l=0;
        int r=n-1;
        while(l<r)
        {
            while(l<r && !isalnum(s[l])) l++;
            while(l<r && !isalnum(s[r])) r--;
            if(tolower(s[l])!=tolower(s[r])) return false;
            else 
            {
                l++;
                r--;
            }
        }
        return true;
    }
};