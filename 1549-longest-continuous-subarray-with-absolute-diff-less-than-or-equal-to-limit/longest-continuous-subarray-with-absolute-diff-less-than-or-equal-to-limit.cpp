class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        int len=0;
        deque<int> maxq;
        deque<int> minq;
        int l,r;
        l=r=0;
        while(r<nums.size())
        {
            while(!maxq.empty() && maxq.back()<nums[r]) maxq.pop_back();
            while(!minq.empty() && minq.back()>nums[r]) minq.pop_back();

            maxq.push_back(nums[r]);
            minq.push_back(nums[r]);

            while(l<=r && maxq.front()-minq.front()>limit)
            {
                if(nums[l]==maxq.front()) maxq.pop_front();
                if(nums[l]==minq.front()) minq.pop_front();
                l++;
            }
            len = max(len,r-l+1);
            r++;
        }
        return len;
    }
};