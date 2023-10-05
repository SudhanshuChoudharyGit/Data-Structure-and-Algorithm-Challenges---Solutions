class Solution {

    public int binarySearch(int target,int[] nums,int l,int r)
    {
        int ind = -1;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(nums[m]<=target)
            {
                ind = m;
                l = m+1;
            }
            else r = m-1;
        }
        if(ind==-1) return -1;
        return (nums[ind]==target) ? ind : -1;
    }

    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int ind = binarySearch(original,nums,l,r);
        while(ind!=-1)
        {
            original*=2;
            l = ind+1;
            ind = binarySearch(original,nums,l,r);
        }
        return original;
    }
}