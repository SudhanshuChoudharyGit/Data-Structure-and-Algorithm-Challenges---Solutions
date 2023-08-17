class Solution {
public:

    long long maximumSubarraySum(vector<int>& nums, int k) {
        int l,r;
        l=r=0;
        long long currsum = 0;
        long long maxsum = 0; 
        unordered_map<int,int> mp;
        while(r<nums.size())
        {
            mp[nums[r]]++;
            currsum+=nums[r];
            if(r-l+1==k)
            {
                if(mp.size()==k) maxsum = max(maxsum,currsum);
                mp[nums[l]]--;
                currsum-=nums[l];
                if(mp[nums[l]]==0) mp.erase(nums[l]);
                l++;
            }
            r++;
        }
        return maxsum;
    }
};