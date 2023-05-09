class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        //map (for frequency)and priority queue(for holding top k frequency elements)
        vector<int> ans;
        unordered_map<int,int> count;
        for(int element : nums)
        {
            count[element]++;
        }

        priority_queue<pair<int,int>> pq;
        for(auto it : count)
        {
            pq.push(make_pair(it.second,it.first));
            if(pq.size()>count.size()-k)
            {
                ans.push_back(pq.top().second);
                if(ans.size()==k) return ans;
                pq.pop();
            }
        }
        return ans;
    }
};