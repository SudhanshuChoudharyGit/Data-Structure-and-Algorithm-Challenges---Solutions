class Solution {
public:
    int findMin(vector<int>& nums) {
        int n=nums.size();
        if(n==1) return nums[0];
        int l=0;
        int r=n-1;
        while(l<r)
        {
            int m=(r-l)/2+l;
            if(r==l+1 && nums[r]<nums[l]) return nums[r];
            if(nums[l]<=nums[m] && nums[m]<nums[r]) break;
            else if(nums[l]<nums[m]) l=m;
            else r=m;
        }
        return nums[l];
































        /*
        int n=nums.size();
        if(n==1) return nums[0];
        int l=0;
        int r=n-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(mid>0 && nums[mid]<nums[mid-1]) return nums[mid];
            else if(nums[mid]>=nums[l])
            {
                if(nums[mid]<nums[r]) return nums[l];
                else l=mid+1;
            }
            else r=mid-1;
        }
        return nums[0];
        */
    }
};