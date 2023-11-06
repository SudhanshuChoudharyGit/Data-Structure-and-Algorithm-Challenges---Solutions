class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int i = 1;
        while(i<n-1)
        {
            if((nums[i-1]>nums[i] && nums[i]>nums[i+1]) || (nums[i-1]<nums[i] && nums[i]<nums[i+1]))
            {
                int y = nums[i+1];
                nums[i+1] = nums[i];
                nums[i] = y;
            }
            i++;
        }
        return nums;
    }
}