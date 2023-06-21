class Solution {
public:

    void fun(vector<int>& nums,unordered_set<int> s,vector<int> v,vector<vector<int>>& ans, int i,int n)
    {
        for(int j=0;j<n;j++)
        {
            if(s.find(nums[j])!=s.end()) continue;
            s.insert(nums[j]);
            v.push_back(nums[j]);
            if(v.size()==n) ans.push_back(v);
            else fun(nums,s,v,ans,j,n);
            s.erase(nums[j]);
            v.pop_back();
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        int n = nums.size();
        for(int i=0;i<n;i++)
        {
            unordered_set<int> s;
            vector<int> v;
            s.insert(nums[i]);
            v.push_back(nums[i]);
            if(v.size()==n) ans.push_back(v);
            else fun(nums,s,v,ans,i,n);
            s.erase(nums[i]);
            v.pop_back();
        }
        return ans;
    }

};