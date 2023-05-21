class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int n=intervals.size();
        if(n==1) return intervals;
        vector<vector<int>> ans;
        sort(intervals.begin(),intervals.end());
        int currStart=intervals[0][0];
        int currEnd=intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0]<=currEnd) currEnd=max(currEnd,intervals[i][1]);
            else
            {
                ans.push_back({currStart,currEnd});
                currStart=intervals[i][0];
                currEnd=intervals[i][1];
            }
        }
        ans.push_back({currStart,currEnd});
        return ans;
    }
};