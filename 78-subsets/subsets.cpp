class Solution {
public:

    void backtrack(vector<int>& nums,int start_index,vector<vector<int>>& ans,vector<int> entry) {
        ans.push_back(entry);

        for(int i=start_index; i<nums.size(); i++)
        {
            entry.push_back(nums[i]);
            backtrack(nums,i+1,ans,entry);
            entry.pop_back();
        }
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> entry;
        backtrack(nums,0,ans,entry);
        return ans;
    }













    //using backtracking
    // void backtrack(vector<int>& nums,vector<int> v,vector<vector<int>>& ans,int index)
    // {
    //     ans.push_back(v);

    //     for(int i=index;i<nums.size();i++)
    //     {
    //         v.push_back(nums[i]);

    //         backtrack(nums,v,ans,i+1);

    //         v.pop_back();
    //     }
    // }
    // vector<vector<int>> subsets(vector<int>& nums) {
    //     vector<vector<int>> ans;
    //     vector<int> v;
    //     int index=0;
    //     backtrack(nums,v,ans,index);
    //     return ans;
    // }
};