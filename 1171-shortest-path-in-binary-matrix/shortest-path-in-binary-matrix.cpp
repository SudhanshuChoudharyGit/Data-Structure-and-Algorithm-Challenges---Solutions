class Solution {
public:

    //DFS

    vector<pair<int,int>> getNeighbours(pair<int,int> p, vector<vector<int>>& grid, vector<vector<bool>>& vis)
    {
        vector<pair<int,int>> ans;
        vector<pair<int,int>> coords = {{-1,0},{0,-1},{0,1},{1,0},{-1,-1,},{-1,1},{1,-1,},{1,1}};
        for(int i=0;i<8;i++)
        {
            int x = p.first + coords[i].first;
            int y = p.second + coords[i].second;
            if(x>=0 && y>=0 && x<grid.size() && y<grid[0].size() && !vis[x][y] && grid[x][y]==0) ans.push_back({x,y});
        }
        return ans;
    }

    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        if(grid[0][0]==1) return -1;
        vector<vector<bool>> vis(grid.size(),vector<bool>(grid[0].size(),false));
        queue<pair<int,int>> q;
        q.push({0,0});
        vis[0][0]=true;
        int dis = 1;
        while(!q.empty())
        {
            int stepSize = q.size();
            while(stepSize--)
            {
                pair<int,int> p = q.front();
                q.pop();
                if(p.first==grid.size()-1 && p.second==grid[0].size()-1) return dis;
                for(auto n : getNeighbours(p,grid,vis)) 
                {
                    q.push(n);
                    vis[n.first][n.second]=true;
                }
            }
            dis++;
        }
        return -1;
    }
};