class Solution {
public:
    int rob(vector<int>& nums) {
        int last=0;
        int second_last=0;
        for(int i=0;i<nums.size();i++)
        {
            int curr_max=max(last,second_last+nums[i]);
            second_last=last;
            last=curr_max;
        }
        return last;
    }
};