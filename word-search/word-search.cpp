class Solution {
public:

    bool isSafe(int i,int j,int n,int m) {
        if(i>=0 && i<n && j>=0 && j<m) return true;
        else return false;
    }

    bool dfs(vector<vector<char>>& board,string word,vector<vector<bool>>& vis,int n,int i,int j) {
        if(n==word.length()) return true;
        vis[i][j]=true;

        if(isSafe(i,j+1,board.size(),board[0].size()) && !vis[i][j+1] && word[n]==board[i][j+1]) 
        if(dfs(board,word,vis,n+1,i,j+1)) return true;
        if(isSafe(i,j-1,board.size(),board[0].size()) && !vis[i][j-1] && word[n]==board[i][j-1]) 
        if(dfs(board,word,vis,n+1,i,j-1)) return true;
        if(isSafe(i+1,j,board.size(),board[0].size()) && !vis[i+1][j] && word[n]==board[i+1][j]) 
        if(dfs(board,word,vis,n+1,i+1,j)) return true;
        if(isSafe(i-1,j,board.size(),board[0].size()) && !vis[i-1][j] && word[n]==board[i-1][j]) 
        if(dfs(board,word,vis,n+1,i-1,j)) return true;

        vis[i][j]=false;
        return false;
    }

    bool exist(vector<vector<char>>& board, string word) {
        vector<vector<bool>> vis(board.size(),vector<bool>(board[0].size(),false));
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board[0].size();j++)
            {
                if(board[i][j]==word[0] && dfs(board,word,vis,1,i,j)) return true;
            }
        }
        return false;
    }
};