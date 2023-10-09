class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int first = -1;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(nums[m]>= target)
            {
                first = m;
                r = m-1;
            }
            else l = m+1;
        }
        if(first!=-1) first = (nums[first]==target) ? first : -1;
        l = 0;
        r = nums.length - 1;
        int last = -1;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(nums[m]<= target)
            {
                last = m;
                l = m+1;
            }
            else r = m-1;
        }
        if(last!=-1) last = (nums[last]==target) ? last : -1;
        int[] ans = new int[2];
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
}