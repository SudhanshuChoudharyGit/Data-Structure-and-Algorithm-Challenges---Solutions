class Solution {
public:

    void fun(vector<string>& ans,int t_open,int t_close,int open,int close,string s)
    {
        if(t_open==0 && t_close==0) 
        {
            ans.push_back(s);
            return;
        }
        if(t_open>0)
        {
            s+="(";
            fun(ans,t_open-1,t_close,open+1,close,s);
            s.pop_back();
        }
        if(t_close>0 && close<open)
        {
            s+=")";
            fun(ans,t_open,t_close-1,open,close+1,s);
            s.pop_back();
        }
    }

    vector<string> generateParenthesis(int n) {
        int t_open=n;
        int t_close=n;
        int open=0;
        int close=0;
        vector<string> ans;
        string s="";
        fun(ans,t_open,t_close,open,close,s);
        return ans;
    }
};