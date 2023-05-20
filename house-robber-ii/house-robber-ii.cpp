class Solution {
public:

    int rob_helper(vector<int>& nums,int l,int r)
    {
        int last=0;
        int second_last=0;
        for(int i=l;i<=r;i++)
        {
            int maxtillnow=max(last,second_last+nums[i]);
            second_last=last;
            last=maxtillnow;
        }
        return last;
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n==1) return nums[0];
        else return max(rob_helper(nums,0,n-2),rob_helper(nums,1,n-1));
    }
};