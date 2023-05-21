class Solution {
public:

    int binarysearchfirstgreater(vector<int>& sub,int target) {
        int ans=0;
        int l=0;
        int r=sub.size()-1;
        while(l<=r)
        {
            int m = (r-l)/2 + l;
            if(sub[m]>=target) 
            {
                ans=m;
                r=m-1;
            }
            else l=m+1;
        }
        return ans;
    }

    int lengthOfLIS(vector<int>& nums) {

        //dynamic programming - classic
        //the length of longest increasing subsequence ending at index i would be 
        //maximum amoung the LIS of previous indexs where values at those index j is 
        //smaller than value at i
        /*
        int n = nums.size();
        int maxlength=1;
        vector<int> dp(n,1);
        for(int i=1;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[j]<nums[i] && dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                    maxlength=max(maxlength,dp[i]);
                }
            }
        }
        return maxlength;
        */

        //Greedy with binary search
        vector<int> sub;
        sub.push_back(nums[0]);
        for(int i=1;i<nums.size();i++)
        {
            if(nums[i]>sub[sub.size()-1]) sub.push_back(nums[i]);
            else
            {
                int index = binarysearchfirstgreater(sub,nums[i]);
                sub[index]=nums[i];
            }
        }
        return sub.size();
    }
};