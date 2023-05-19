class Solution {
public:
    int findMin(vector<int>& nums) {
        int n=nums.size();
        if(n==1) return nums[0];
        int l,r;
        l=0;
        r=n-1;
        while(l<r)
        {
            int m=(r+l)/2;
            if(m>0 && nums[m]<nums[m-1]) return nums[m];
            if(nums[l]<=nums[m])
            {
                if(nums[m]<nums[r]) return nums[l];
                l=m+1;
            }
            else r=m-1;
        }
        return nums[l];
    }
};