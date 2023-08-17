class Solution {
public:

    vector<pair<int,int>> getNeighbours(pair<int,int> p, vector<vector<char>>& board, vector<vector<bool>>& vis)
    {
        vector<pair<int,int>> ans;
        vector<pair<int,int>> coords = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<8;i++)
        {
            int x = p.first + coords[i].first;
            int y = p.second + coords[i].second;
            if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && !vis[x][y] && board[x][y]=='E') ans.push_back({x,y});
        }
        return ans;
    }

    int adjacentMines(pair<int,int> p, vector<vector<char>>& board)
    {
        int ans=0;
        vector<pair<int,int>> coords = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<8;i++)
        {
            int x = p.first + coords[i].first;
            int y = p.second + coords[i].second;
            if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y]=='M' ) ans++;
        }
        return ans;
    }

    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        queue<pair<int,int>> q;
        vector<vector<bool>> vis(board.size(),vector<bool>(board[0].size(),false));
        if(board[click[0]][click[1]]=='M')
        {
            board[click[0]][click[1]]='X';
            return board;
        }
        q.push({click[0],click[1]});
        vis[click[0]][click[1]]=true;
        while(!q.empty())
        {
            pair<int,int> p = q.front();
            q.pop();
            int count = adjacentMines(p,board);
            if(count>0)
            {
                board[p.first][p.second]='0'+count;
                continue;
            }
            for(auto n : getNeighbours(p,board,vis))
            {
                vis[n.first][n.second]=true;
                q.push(n);
            }
            board[p.first][p.second]='B';
        }
        return board;
    }
};