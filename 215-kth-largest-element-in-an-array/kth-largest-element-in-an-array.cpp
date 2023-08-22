class Solution {
public:

    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        //n-k+1 elements with max at top
        int i;
        for(i=0;i<=nums.size()-k;i++) pq.push(nums[i]);

        while(i<nums.size())
        {
            if(nums[i]<pq.top())
            {
                pq.pop();
                pq.push(nums[i]);
            }
            i++;
        }

        return pq.top();
    }



































    // int findKthLargest(vector<int>& nums, int k) {
    //     priority_queue<int> pq;
    //     for(int i=0;i<nums.size();i++)
    //     {
    //         pq.push(nums[i]);
    //         if(pq.size()>2) pq.pop_back();
    //     }
    //     k--;
    //     while(k--) pq.pop();
    //     return pq.top();
    // }
};