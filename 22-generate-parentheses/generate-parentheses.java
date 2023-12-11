class Solution {

    public void helper(int open,int close, String curr, int n,List<String> ans) {
        if(curr.length()==2*n)
        {
            ans.add(curr);
            return;
        }
        if(open<n) helper(open+1,close,curr+"(",n,ans);
        if(close<open) helper(open,close+1,curr+")",n,ans);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = 0;
        int close = 0;
        String curr = "";
        helper(open,close,curr,n,ans);
        return ans;
    }
}