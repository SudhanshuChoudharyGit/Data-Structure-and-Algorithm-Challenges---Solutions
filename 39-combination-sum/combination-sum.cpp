class Solution {
public:

// bool backtrack(vector<int>& candidates, int target,int index,int sum,vector<int>& v,vector<vector<int>>& ans) {
//     sum+=candidates[index];
//     v.push_back(candidates[index]);
//     if(sum==target)
//     {
//         ans.push_back(v);
//     }
//     else if(sum<target)
//     {
//         for(int i=index;i<candidates.size();i++)
//         {
//             if(sum+candidates[i]>target) break;
//             backtrack(candidates,target,i,sum,v,ans);
//         }
//     }
//     v.pop_back();
//     return true;
// }

// vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
//     vector<vector<int>> ans;
//     if(target==1) return ans;
//     int n=candidates.size();
//     sort(candidates.begin(),candidates.end());
//     int sum=0;
//     vector<int> v;
//     for(int i=0;i<n;i++)
//     {
//         if(candidates[i]>target) break;
//         backtrack(candidates,target,i,sum,v,ans);
//     }
//     return ans;
// }

    



//approach : backtracking

    void backtrack(vector<int>& candidates, int target,int start_index,vector<int> entry,vector<vector<int>>& ans)
    {
        if(target==0)
        {
            ans.push_back(entry);
            return;
        }
        for(int i=start_index;i<candidates.size();i++)
        {
            if(candidates[i]>target) break;
            entry.push_back(candidates[i]);
            backtrack(candidates,target-candidates[i],i,entry,ans);
            entry.pop_back();
        }
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
        vector<vector<int>> ans;
        vector<int> entry;
        backtrack(candidates,target,0,entry,ans);
        return ans;
    }


























/*
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
*/
};