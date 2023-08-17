class Solution {
public:

    vector<pair<int,int>> getNeighbours(pair<int,int> node,vector<vector<int>>& grid)
    {
        vector<pair<int,int>> ans;
        vector<pair<int,int>> coords = {{-1,0},{0,-1},{0,1},{1,0}};
        for(int i=0;i<4;i++)
        {
            int x = node.first + coords[i].first;
            int y = node.second + coords[i].second;
            if(x>=0 && y>=0 && x<grid.size() && y<grid[0].size() && grid[x][y]==1) ans.push_back({x,y});
        }
        return ans;
    }

    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> q;
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[0].size();j++)
            {
                if(grid[i][j]==2) q.push({i,j});
            }
        }

        //multi-source BFS
        int time = 0;
        bool flag=false;
        while(!q.empty())
        {
            int stepSize = q.size();
            while(stepSize--)
            {
                pair<int,int> node = q.front();
                q.pop();
                for(auto n : getNeighbours(node,grid))
                {
                    flag=true;
                    q.push(n);
                    grid[n.first][n.second]=2;
                }
            }
            if(flag)
            {
                time++;
                flag= !flag;
            }
        }

        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[0].size();j++)
            {
                if(grid[i][j]==1) return -1;
            }
        }
        return time;
    }
};