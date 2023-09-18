class Solution {

    int[][] coord = {{-1,0},{0,-1},{0,1},{1,0}};

    public boolean dfs(char[][] board,String word,boolean[][] vis,int i,int j,int ind,int m,int n)
    {
        if(ind>=word.length()) return true;
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j]==true || word.charAt(ind)!=board[i][j]) return false;
        vis[i][j]=true;

        for(int in = 0;in<4;in++)
        {
            int x = coord[in][0];
            int y = coord[in][1];
            if(dfs(board,word,vis,i+x,j+y,ind+1,m,n)) return true;
        }
        vis[i][j]=false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis= new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(board,word,vis,i,j,0,m,n)==true) return true;
                }
            }
        }
        return false;
    }
}