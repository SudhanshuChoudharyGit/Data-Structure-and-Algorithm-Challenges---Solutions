class Solution {
public:

    void backtrack(vector<string>& ans,string entry,int op,int cp)
    {
        if(op==0 && cp==0)
        {
            ans.push_back(entry);
            return;
        }
        if(op>0) backtrack(ans,entry+"(",op-1,cp);
        if(cp>op) backtrack(ans,entry+")",op,cp-1);

    }

    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        string entry;
        backtrack(ans,entry,n,n);
        return ans;
    }
};