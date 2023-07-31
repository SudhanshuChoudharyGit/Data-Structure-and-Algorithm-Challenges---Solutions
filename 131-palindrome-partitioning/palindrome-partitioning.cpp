class Solution {
public:

    bool isPalindrome(string sub) {
        string rev="";
        for(int i=sub.length()-1;i>=0;i--)
        {
            rev+=sub[i];
        }
        return rev==sub;
    }

    void backtrack(string& s,vector<vector<string>>& ans,vector<string>& entry,int i) {
        if (i==s.length())
        {
            ans.push_back(entry);
            return;
        }

        for(int j=i;j<s.length();j++)
        {
            string sub = s.substr(i,j-i+1);
            if(!isPalindrome(sub)) continue;
            entry.push_back(sub);
            backtrack(s,ans,entry,j+1);
            entry.pop_back();
        }
    }


    vector<vector<string>> partition(string s) {
        vector<vector<string>> ans;
        vector<string> entry;
        backtrack(s,ans,entry,0);
        return ans;
    }
};