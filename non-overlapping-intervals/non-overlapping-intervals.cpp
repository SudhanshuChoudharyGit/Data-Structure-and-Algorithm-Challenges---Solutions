bool comp(vector<int>& INT1, vector<int>& INT2) {
    return INT1[1]<INT2[1];
}

class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        //Greedy Algo
        //sort by ending
        //if overlap is there, remove the second one 
        //as it keep the resulting ending to a minimum
        sort(intervals.begin(),intervals.end(),comp);
        int ans=-1;
        int prevEnd=intervals[0][1];
        for(auto v : intervals)
        {
            if(prevEnd>v[0])
            {
                ans++;
            }
            else prevEnd=v[1];
        }
        return ans;
    }
};