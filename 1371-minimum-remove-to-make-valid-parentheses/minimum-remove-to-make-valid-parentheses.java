class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> invalids = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == ')' || s.charAt(i)=='(')
            {
                if(s.charAt(i) == ')' && !invalids.empty() && s.charAt(invalids.peek())=='(') invalids.pop();
                else invalids.push(i);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
        {
            if(!invalids.empty() && invalids.peek()==i) invalids.pop();
            else ans.append(s.charAt(i));
        }
        return ans.reverse().toString();
    }
}