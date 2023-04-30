class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        //approach 1: using multimap

        unordered_multimap<int,int> mp;


        for(int i=0;i<nums.size();i++)
        {
            mp.insert({nums[i],i});
        }

        for(int i=0;i<nums.size();i++)
        {
                if(mp.find(target-nums[i])!=mp.end())
                {
                    auto r = mp.equal_range(target-nums[i]);
                    for(auto it=r.first;it!=r.second;++it)
                    {
                        if(it->second!=i) return {i,it->second};
                    }
                }
        }

        return {0,1};
    }
};