class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n=nums.size();
        if(n==1) return true;
        int need=1;
        for(int i=nums.size()-2;i>=0;i--)
        {
            if(nums[i]>=need) need=0;
            need++;
        }
        if(need==1) return true;
        else return false;
    }
};