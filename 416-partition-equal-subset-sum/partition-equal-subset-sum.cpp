class Solution {
public:

    bool canPartition(vector<int>& nums) {
        int totalsum=0;

        for(auto num : nums) totalsum+=num;

        if(totalsum%2!=0) return false;

        int targetNum = totalsum/2;

        vector<vector<bool>> dp(2,vector<bool>(targetNum+1,false));

        dp[0][0]=true;

        for(auto num : nums)
        {
            for(int target=0;target<=targetNum;target++)
            {
                dp[1][target] = dp[0][target];

                if(target>=num)
                dp[1][target] = dp[1][target] || dp[0][target-num];
            }

            for(int target=0;target<=targetNum;target++)
            {
                if(dp[1][target]) dp[0][target]=true;
            }
        }

        return dp[0][targetNum];
    }









// Backtracking + memo = top down dp
/*

    int backtrack(vector<int>& nums, int total, int currsum,int index, vector<vector<int>>& memo) {
        if(memo[currsum][index]!=-1) return memo[currsum][index];

        if(currsum==total/2)
        {
            memo[currsum][index]=1;
            return 1;
        }

        if (currsum>total/2 || index==nums.size()) {
            memo[currsum][index]=0;
            return 0;
        }

        int first = backtrack(nums,total,currsum,index+1,memo);
        int second = backtrack(nums,total,currsum+nums[index],index+1,memo);

        memo[currsum][index] = first || second;
        return memo[currsum][index];
    }


    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        int total=0;
        for(int x : nums) total+=x;
        
        if(total%2!=0) return false;
        vector<vector<int>> memo(total+1,vector<int>(n+1,-1));
        
        int ans = backtrack(nums, total, 0, 0, memo);
        return ans == 1;
    }
*/
};