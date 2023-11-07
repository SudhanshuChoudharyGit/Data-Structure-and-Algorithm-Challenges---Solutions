class Solution {
    public int minOperations(int[] nums, int x) {
        //maximum length subarray with sum = total sum - x;
        int n = nums.length;
        int totalSum = 0;
        for(int ele : nums) totalSum+= ele;
        int target = totalSum - x;
        if(target<0) return -1;
        if(target==0) return n;
        int l = 0;
        int r = 0;
        int currSum = 0;
        int len = -1;
        while(r<n)
        {
            currSum += nums[r];
            while(l<=r && currSum>target)
            {
                currSum -= nums[l];
                l++;
            }
            if(currSum==target) len = Math.max(len,r-l+1);
            r++;
        }
        if(len==-1) return -1;
        return n-len;
    }
}