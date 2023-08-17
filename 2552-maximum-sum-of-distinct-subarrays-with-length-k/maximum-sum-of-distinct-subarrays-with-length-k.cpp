class Solution {
public:

    long long maximumSubarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> mp;
        long long maxsum=0;
        long long currsum=0;
        int l=0;
        int r=0;
        bool dup=false;
        while(k--)
        {
            mp[nums[r]]++;
            currsum+=nums[r];
            r++;
        }
        if(mp.size()==r-l) maxsum=max(maxsum,currsum);
        while(r<nums.size())
        {
            currsum-=nums[l];
            mp[nums[l]]--;
            if(mp[nums[l]]==0) mp.erase(nums[l]);
            l++;
            currsum+=nums[r];
            mp[nums[r]]++;
            r++;
            if(mp.size()==r-l) maxsum=max(maxsum,currsum);
        }
        return maxsum;
    }
};