class Solution {
public:



int longestConsecutive(vector<int>& nums) {
    unordered_map<int,int> isNextPresent;
    for(int num : nums) isNextPresent[num]=false;
    for(int num : nums)
    {
        if(isNextPresent.count(num+1)>0) isNextPresent[num]=true;
    }
    int ans=0;
    for(int num : nums)
    {
        if(isNextPresent.count(num-1)==0)
        {
            int count=1;
            while(isNextPresent[num])
            {
                count++;
                num=num+1;
            }
            ans=max(ans,count);
        }
    }
    return ans;
}































/*
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int,bool> mp;
        for(int n: nums) mp[n]=true;
        for(int n: nums)
        {
            if(mp.count(n-1)>0) mp[n]=false;
        }
        int ans=0;
        for(int n:nums)
        {
            if(mp[n])
            {
                int count=0;
                int j=0;
                while(mp.count(n+j)>0)
                {
                    count++;
                    j++;
                }
                ans=max(ans,count);
            }
        }
        return ans;


    }
*/
};