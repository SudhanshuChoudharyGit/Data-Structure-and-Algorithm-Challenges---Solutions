class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        priority_queue<pair<float,int>,vector<pair<float,int>>,greater<>> pq;
        for(int i=0;i<points.size();i++)
        {
            vector<int> v = points[i];
            float dis = sqrt(pow(v[0],2)+pow(v[1],2));
            pq.push({dis,i});
        }

        vector<vector<int>> ans;
        while(k--)
        {
            ans.push_back(points[pq.top().second]);
            pq.pop();
        }

        return ans;
    }
};