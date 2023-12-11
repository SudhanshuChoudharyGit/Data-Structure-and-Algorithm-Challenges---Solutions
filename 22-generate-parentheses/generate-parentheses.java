class Solution {

    //recursive function
    public void helper(int open,int close,String curr,List<String> ans,int n) {
        //base case (ending condition)
        if(curr.length()==2*n)
        {
            ans.add(curr);
            return;
        }

       //open use
        if(open<n)
        {
            helper(open+1,close,curr+"(",ans,n);
        }

        //close use
        if(open>close)
        {
            helper(open,close+1,curr+")",ans,n);
        }
        
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = 0;
        int close = 0;
        String curr = "";
        helper(open,close,curr,ans,n);
        return ans;
    }
}