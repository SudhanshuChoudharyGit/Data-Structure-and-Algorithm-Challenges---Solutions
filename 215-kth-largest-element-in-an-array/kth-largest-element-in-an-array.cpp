class Solution {
public:

    //using n-k extra space
    // int findKthLargest(vector<int>& nums, int k) {
    //     priority_queue<int> pq;
    //     //n-k+1 elements with max at top
    //     int i;
    //     for(i=0;i<=nums.size()-k;i++) pq.push(nums[i]);

    //     while(i<nums.size())
    //     {
    //         if(nums[i]<pq.top())
    //         {
    //             pq.pop();
    //             pq.push(nums[i]);
    //         }
    //         i++;
    //     }

    //     return pq.top();
    // }


    void maxHeapify(vector<int>& nums, int i)
    {
        int l = 2*i+1;
        int r = 2*i+2;
        int largest=i;
        if(l<nums.size() && nums[l]>nums[i]) largest = l;
        if(r<nums.size() && nums[r]>nums[largest]) largest = r;
        if(largest!=i)
        {
            swap(nums[i],nums[largest]);
            maxHeapify(nums,largest);
        }
    }

    void pop(vector<int>& nums)
    {
        swap(nums[nums.size()-1],nums[0]);
        nums.pop_back();
        maxHeapify(nums,0);
    }

    //using 0 extra space
    int findKthLargest(vector<int>& nums, int k) {
        for(int i=nums.size()/2-1;i>=0;i--)
        {
            maxHeapify(nums,i);
        }
        k--;
        while(k--)
        {
            pop(nums);
        }
        return nums[0];
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