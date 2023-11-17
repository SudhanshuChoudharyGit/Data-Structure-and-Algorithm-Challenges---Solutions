class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currEnd = 0;
        int currFarthest = 0;
        int jumps = 0;
        for(int i=0;i<n-1;i++)
        {
            currFarthest = Math.max(currFarthest,i+nums[i]);
            if(i==currEnd)
            {
                jumps++;
                currEnd = currFarthest;

            }
        }
        return jumps;
    }
}