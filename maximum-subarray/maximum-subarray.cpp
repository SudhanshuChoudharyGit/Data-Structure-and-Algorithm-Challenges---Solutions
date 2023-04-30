class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        //two pointers algorithm

        int i=0;
        int j=0;

        int max_sum=INT_MIN;
        int curr_sum=0;

        while(j<nums.size())
        {
            curr_sum+=nums[j];
            max_sum=max(max_sum,curr_sum);

            if(curr_sum<0)
            {
                curr_sum=0;
                i=j+1;
            }

            j++;
        }

        return max_sum;
        
    }
};