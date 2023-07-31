class Solution {
public:

    bool isPalindrome(string sub) {
        int l=0;
        int r=sub.length()-1;
        while(l<r)
        {
            if(sub[l]!=sub[r]) return false;
            l++;
            r--;
        }
        return true;
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