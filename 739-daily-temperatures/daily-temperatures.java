class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        //monotincally decreasing stack from start
        /*
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
        }*/

        //monotonically decreasing stack from ene
        for(int i=n-1;i>=0;i--)
        {
            while(st.size()>0 && temperatures[i]>=temperatures[st.peek()]) st.pop();
            if(st.size()==0) ans[i]=0;
            else ans[i]=st.peek()-i;
            st.push(i);
        }

        return ans;
    }
}