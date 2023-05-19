class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> ans(nums.size(),1);
        int prod=1;
        for(int i=1;i<nums.size();i++)
        {
            prod*=nums[i-1];
            ans[i]=prod;
        }
        prod=1;
        for(int i=nums.size()-2;i>=0;i--)
        {
            prod*=nums[i+1];
            ans[i]*=prod;
        }
        return ans;
    }
};