class Solution {
    public String removeOccurrences(String s, String part) {
        //ddbc
        //abc
        int n = s.length();
        int m = part.length();
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray())
        {
            st.push(ch);
            if(st.size()>=m)
            {
               for(int ind = m-1;ind>=0;ind--) 
               {
                   if(st.peek()!=part.charAt(ind)) 
                   {
                       for(int i=ind+1;i<m;i++) st.push(part.charAt(i));
                       break;
                   }
                   else st.pop();
               }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        return sb.toString();
    }
}