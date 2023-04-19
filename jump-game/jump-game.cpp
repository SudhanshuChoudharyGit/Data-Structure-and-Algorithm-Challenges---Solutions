class Solution {
public:
    bool canJump(vector<int>& nums) {
        int max_steps = nums[0];
        for(int i=1;i<nums.size();i++)
        {
          max_steps--;
          if(max_steps<0) return false;
          if(nums[i]>max_steps) max_steps=nums[i];
        }
        return true;
    }
};