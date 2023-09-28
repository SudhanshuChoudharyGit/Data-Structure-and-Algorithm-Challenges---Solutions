class Solution {
    public int heightChecker(int[] heights) {
        int[] diff = Arrays.stream(heights).toArray();
        Arrays.sort(diff);
        int ans  = 0;
        for(int i=0;i<heights.length;i++)
        {
            if(heights[i]!=diff[i]) ans++;
        }
        return ans;
    }
}