class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n=nums.size();
        if(n==1) return (target==nums[0]?0:-1);
        int l,r;
        l=0;r=n-1;
        while(l<=r)
        {
            int m=(r-l)/2+l;
            if(nums[m]==target) return m;
            if(nums[l]<=nums[m])
            {
                if(target<nums[m] && target>=nums[l]) r=m-1;
                else l=m+1;
            }
            else
            {
                if(target>nums[m] && target<=nums[r]) l=m+1;
                else r=m-1;
            }
        }
        return -1;



































        /*
        int l=0;
        int r=nums.size()-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[l])
            {
                if(target>=nums[l] && target<nums[mid]) r=mid-1;
                else l=mid+1;
            }
            else
            {
                if(target>nums[mid] && target<=nums[r]) l=mid+1;
                else r=mid-1;
            }
        }
        return -1;
        */
    }
};