class Solution {
public:

// Approach 1

    // void fun(set<int> s,vector<int> v,vector<vector<int>>& ans,int n,int ele)
    // {
    //     s.erase(ele);
    //     for(int x : s)
    //     {   
    //         v.push_back(x);
    //         if(v.size()==n) ans.push_back(v);
    //         else fun(s,v,ans,n,x);
    //         v.pop_back(); 
    //     }
    // }

    // vector<vector<int>> permute(vector<int>& nums) {
    //     vector<vector<int>> ans;
    //     int n = nums.size();
    //     set<int> s;
    //     for(int i=0;i<n;i++) s.insert(nums[i]);
    //     vector<int> v;
    //     for(int x : s)
    //     {   
    //         v.push_back(x);
    //         if(v.size()==n) ans.push_back(v);
    //         else fun(s,v,ans,n,x);
    //         v.pop_back();   
    //     }
    //     return ans;
    // }

    // Approach 2

    void swapAndSelect(vector<int>& nums,vector<vector<int>>& ans,vector<int> v,int index)
    {
        if(v.size()==nums.size())
        {
            ans.push_back(v);
            return;
        }

        for(int i=index;i<nums.size();i++)
        {
            v.push_back(nums[i]);
            swap(nums[i],nums[index]);
            swapAndSelect(nums,ans,v,index+1);
            v.pop_back();
            swap(nums[i],nums[index]);
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> v;
        swapAndSelect(nums,ans,v,0);
        return ans;
    }

};