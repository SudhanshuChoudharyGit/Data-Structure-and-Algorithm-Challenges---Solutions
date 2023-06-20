class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        int max_point=1;
        int n= points.size();
        for(int i=0;i<n;i++)
        {
            if(n-i<=max_point) break;
            unordered_map<double,int> slopes;
            int x_axis_points=0;
            int count=0;
            for(int j=i+1;j<n;j++)
            {
                if(points[j][0]==points[i][0])
                {
                    x_axis_points++;
                    count=max(count,x_axis_points);
                } 
                else
                {
                    double slope = (double)(points[j][1]-points[i][1])/(points[j][0]-points[i][0]);
                    slopes[slope]++;
                    count=max(count,slopes[slope]);
                }
            }
            max_point=max(max_point,count+1);
        }
        return max_point;
    }
};