class Solution {
public:

    bool isPalindrome(string s)
    {
        int l=0;int r=s.length()-1;
        while(l<r)
        {
            if(s[l]!=s[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    void backtrack(string s,vector<vector<string>>& ans,vector<string>& pos,int index) {
        if(index==s.length())
        {
            ans.push_back(pos);
            return;
        }
        for(int i=index;i<s.length();i++)
        {
            string substring = s.substr(index,i-index+1);
            if(!isPalindrome(substring)) continue;
            pos.push_back(substring);
            backtrack(s,ans,pos,i+1);
            pos.pop_back();
        }
    }

    vector<vector<string>> partition(string s) {
        vector<vector<string>> ans;
        vector<string> pos;
        backtrack(s,ans,pos,0);
        return ans;
    }
};