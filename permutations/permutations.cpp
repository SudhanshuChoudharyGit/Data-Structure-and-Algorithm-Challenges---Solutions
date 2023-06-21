class Solution {
public:

    void fun(set<int> s,vector<int> v,vector<vector<int>>& ans,int n,int ele)
    {
        s.erase(ele);
        for(int x : s)
        {   
            v.push_back(x);
            if(v.size()==n) ans.push_back(v);
            else fun(s,v,ans,n,x);
            v.pop_back(); 
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        int n = nums.size();
        set<int> s;
        for(int i=0;i<n;i++) s.insert(nums[i]);
        vector<int> v;
        for(int x : s)
        {   
            v.push_back(x);
            if(v.size()==n) ans.push_back(v);
            else fun(s,v,ans,n,x);
            v.pop_back();   
        }
        return ans;
    }

};