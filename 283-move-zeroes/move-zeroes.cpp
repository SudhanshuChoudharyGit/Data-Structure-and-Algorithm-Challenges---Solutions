class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int l,r;
        l=r=0;
        while(r<nums.size())
        {
            if(nums[r]!=0)
            {

                int x = nums[l];
                nums[l]=nums[r];
                nums[r]=x;
                l++;
            }
            r++;
        }
    }
};