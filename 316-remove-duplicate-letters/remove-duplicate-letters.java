class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] lastOcc = new int[26];
        for(int i=0;i<s.length();i++)
        {
            int ind = s.charAt(i)-'a';
            lastOcc[ind] = i;
        }

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            int ind = s.charAt(i)-'a';
            if(vis[ind]) continue;
            while(st.size()>0 && st.peek()>=ind)
            {
                if(lastOcc[st.peek()]<i) break;
                vis[st.peek()] = false;
                st.pop();
            }
            st.push(ind);
            vis[ind]=true;
        }

        StringBuilder sb = new StringBuilder();
        while(st.size()>0) sb.append((char)(st.pop()+'a'));
        return sb.reverse().toString();
    }
}