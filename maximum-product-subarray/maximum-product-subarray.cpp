class Solution {
public:
    int maxProduct(vector<int>& nums) {
        //Kadane's algorithm, implementation

        //use current product, make it 1 when encountered 0
        //use a max one, compare with current

        //here need to do from both sides 
        int curr_max=1;
        int max_so_far=INT_MIN;

        for(int num : nums)
        {
          curr_max*=num;
          max_so_far=max(max_so_far,curr_max);
          if(curr_max==0) curr_max=1;
        }

        curr_max=1;
        for(int i=nums.size()-1;i>=0;i--)
        {
          curr_max*=nums[i];
          max_so_far=max(max_so_far,curr_max);
          if(curr_max==0) curr_max=1;
        }

        return max_so_far;

    }
};