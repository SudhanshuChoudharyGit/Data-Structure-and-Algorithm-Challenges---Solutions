class Solution {
public:

    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> ans;
        for(int i=0;i<=nums.size()-3;i++)
        {
            if(nums[i]>0 || (i>0 && nums[i-1]==nums[i])) continue;
            int j=i+1;
            int k=nums.size()-1;
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    ans.push_back({nums[i],nums[j],nums[k]});
                    while(j<k && nums[j+1]==nums[j]) j++;
                    j++;
                    k--;
                }
                else if(sum>0) k--;
                else j++;
            }
        }
        return ans;
    }



































    // vector<vector<int>> threeSum(vector<int>& nums) {
    //     vector<vector<int>> ans;
    //     sort(nums.begin(),nums.end());
    //     int n=nums.size();
    //     int i=0;
    //     while(i<n-2 && nums[i]<=0)
    //     {
    //         if(i>0 && nums[i]==nums[i-1])
    //         {
    //             i++;
    //             continue;
    //         }
    //         int j=i+1;
    //         int k=n-1;
    //         while(j<k)
    //         {
    //             int sum=nums[i]+nums[j]+nums[k];
    //             if(sum<0) j++;
    //             else if(sum>0) k--;
    //             else 
    //             {
    //                 ans.push_back({nums[i],nums[j],nums[k]});
    //                 j++;
    //                 while(j<k && nums[j]==nums[j-1]) j++;
    //                 k=n-1;
    //             }
    //         }
    //         i++;
    //     }
    //     return ans;
    // }
};