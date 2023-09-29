class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = false;
        boolean dec = false;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1]) inc = true;
            if(nums[i]<nums[i-1]) dec = true;
        }
        if((inc==false && dec==false) || (inc^dec==true)) return true;
        return false;
    }
}