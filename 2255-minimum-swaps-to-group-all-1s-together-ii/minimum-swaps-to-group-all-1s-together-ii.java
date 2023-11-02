class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int winSize = 0;
        for(int x : nums) winSize+=x;
        int currWinCount = 0;
        int maxWinCount = 0;
        while(l<n)
        {
            if(r<winSize)
            {
                currWinCount += nums[r];
            }
            else
            {
                currWinCount -= nums[l];
                currWinCount += nums[r%n];
                l++;
            }
            r++;
            maxWinCount = Math.max(maxWinCount,currWinCount);
            if(maxWinCount==winSize) return 0;
        }
        return winSize - maxWinCount;
    }
}