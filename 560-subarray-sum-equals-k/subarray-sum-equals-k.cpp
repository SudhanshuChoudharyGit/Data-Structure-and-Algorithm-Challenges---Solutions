class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> prefixSumCount;
        prefixSumCount[0]++;
        int curr=0;
        int ans=0;
        for(int i=0;i<nums.size();i++)
        {
            curr+=nums[i];
            if(prefixSumCount.count(curr-k))
            {
                ans+=prefixSumCount[curr-k];
            }
            prefixSumCount[curr]++;
        }
        return ans;
    }
};