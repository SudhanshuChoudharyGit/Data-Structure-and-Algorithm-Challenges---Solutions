class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int maxtillnow = 0;
        for(int i=0;i<nums.length;i++)
        {
            maxtillnow+=nums[i];
            maxsum = Math.max(maxsum,maxtillnow);
            if(maxtillnow<0)
            {
                maxtillnow = 0;
            }
        }
        return maxsum;
    }
}