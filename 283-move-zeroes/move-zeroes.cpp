class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int l,r;
        l=r=0;
        while(r<nums.size())
        {
            if(nums[r]!=0)
            {

                nums[l]=nums[r];
                l++;
            }
            r++;
        }
        while(l<nums.size())
        {
            nums[l]=0;
            l++;
        }
    }
};