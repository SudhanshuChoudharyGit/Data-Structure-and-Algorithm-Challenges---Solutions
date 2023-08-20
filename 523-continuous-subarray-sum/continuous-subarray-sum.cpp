class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> prefixSum;
        prefixSum[0]=0;
        int currSum=0;
        for(int i=0;i<nums.size();i++)
        {
            currSum+=nums[i];
            int modulo = currSum%k;
            if(prefixSum.count(modulo))
            {
                if(i-prefixSum[modulo]+1>=2) return true;
            }
            else prefixSum[modulo]=i+1;
        }
        return false;
    }
};