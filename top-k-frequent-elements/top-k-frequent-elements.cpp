class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        //bucket sort
        //unordered_map -> filled in vector of vectors with index as frequency
        vector<int> ans;
        unordered_map<int,int> mp;
        for(int n: nums)
        {
            mp[n]++;
        }
        vector<vector<int>> bucket(nums.size()+1);
        for(auto kv: mp)
        {
            bucket[kv.second].push_back(kv.first);
        }

        for(int i=bucket.size()-1;i>=0;i--)
        {
            for(int j=0;j<bucket[i].size();j++)
            {
                ans.push_back(bucket[i][j]);
                if(ans.size()==k) return ans;
            }
        }
        return ans;
    }
};