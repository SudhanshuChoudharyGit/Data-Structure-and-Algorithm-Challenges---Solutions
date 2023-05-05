class Solution {
public:

    bool isSafe(int i,int j,int m,int n)
    {
        if(i>=0 && i<m && j>=0 && j<n) return true;
        else return false;
    }

    bool dfs(vector<vector<char>>& board,int m,int n,string word,int x,int i,int j,vector<vector<bool>>& vis)
    {
        vis[i][j]=true;
        if(x==word.length()-1) return true;

        if(isSafe(i,j-1,m,n) && !vis[i][j-1] && board[i][j-1]==word[x+1])
        if(dfs(board,m,n,word,x+1,i,j-1,vis)) return true;

        if(isSafe(i-1,j,m,n) && !vis[i-1][j] && board[i-1][j]==word[x+1])
        if(dfs(board,m,n,word,x+1,i-1,j,vis)) return true;

        if(isSafe(i,j+1,m,n) && !vis[i][j+1] && board[i][j+1]==word[x+1])
        if(dfs(board,m,n,word,x+1,i,j+1,vis)) return true;

        if(isSafe(i+1,j,m,n) && !vis[i+1][j] && board[i+1][j]==word[x+1])
        if(dfs(board,m,n,word,x+1,i+1,j,vis)) return true;

        vis[i][j]=false;
        return false;
    }

    bool exist(vector<vector<char>>& board, string word) {
        char first=word[0];
        int m=board.size();
        int n=board[0].size();
        vector<vector<bool>> vis(m,vector<bool>(n,false));
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==first)
                {
                    if(dfs(board,m,n,word,0,i,j,vis)) return true;
                }
            }
        }
        return false;
    }
};