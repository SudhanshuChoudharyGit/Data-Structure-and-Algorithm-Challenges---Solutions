class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int lessOnLeft[] = new int[n];
        int ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            while(dq.size()>0 && heights[dq.getLast()]>heights[i])
            {
                int ind = dq.removeLast();
                lessOnLeft[ind] = i;
            }
            dq.addLast(i);
        }
        while(dq.size()>0)
        {
            int ind = dq.removeLast();
            lessOnLeft[ind] = n;
        }
        for(int i=n-1;i>=0;i--)
        {
            while(dq.size()>0 && heights[dq.getLast()]>heights[i])
            {
                int ind = dq.removeLast();
                ans = Math.max(ans,(lessOnLeft[ind]-i-1)*heights[ind]);
            }
            dq.addLast(i);
        }
        while(dq.size()>0)
        {
            int ind = dq.removeLast();
            ans = Math.max(ans,lessOnLeft[ind]*heights[ind]);
        }
        return ans;    
    }
}