class Solution {
public:

    void backtrack(vector<int>& candidates,int target,vector<vector<int>>& ans,vector<int>& curele,int sum,int index) {
        if(sum>target) return;
        if(sum==target)
        {
            ans.push_back(curele);
            return;
        }
        for(int i=index;i<candidates.size();i++)
        {
            curele.push_back(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates,target,ans,curele,sum,i);
            curele.pop_back();
            sum-=candidates[i];
        }
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        //backtracking
        vector<vector<int>> ans;
        vector<int> curele;
        backtrack(candidates,target,ans,curele,0,0);
        return ans;
    }
};