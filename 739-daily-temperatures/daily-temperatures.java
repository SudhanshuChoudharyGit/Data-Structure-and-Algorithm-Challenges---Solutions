class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        //monotincally decreasing stack
        for(int i=0;i<n;i++)
        {
            while(st.size()>0 && temperatures[i]>temperatures[st.peek()])
            {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        while(st.size()>0)
        {
            ans[st.peek()] = 0;
            st.pop();
        }

        return ans;
    }
}