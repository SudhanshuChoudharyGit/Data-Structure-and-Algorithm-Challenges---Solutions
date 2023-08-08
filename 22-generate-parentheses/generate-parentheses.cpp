class Solution {
public:

    void backtrack(vector<string>& ans,string entry,int op,int cp)
    {
        if(op==0 && cp==0)
        {
            ans.push_back(entry);
            return;
        }
        if(op>0)
        {
            entry+="(";
            backtrack(ans,entry,op-1,cp);
            entry=entry.substr(0,entry.length()-1);
        }
        if(cp>op)
        {
            entry+=")";
            backtrack(ans,entry,op,cp-1);
            entry=entry.substr(0,entry.length()-1);
        }
    }

    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        string entry;
        backtrack(ans,entry,n,n);
        return ans;
    }
};