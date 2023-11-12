class Pair{
    int x;
    int y;

    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {


    public ArrayList<Pair> getNeighbours(char[][] board,int m,int n, Pair p){
        int i = p.x;
        int j = p.y;
        ArrayList<Pair> ans = new ArrayList<>();
        if(i-1>=0 && i-1<m && j>=0 && j<n && board[i-1][j]!='B') ans.add(new Pair(i-1,j));
        if(i-1>=0 && i-1<m && j-1>=0 && j-1<n && board[i-1][j-1]!='B') ans.add(new Pair(i-1,j-1));
        if(i-1>=0 && i-1<m && j+1>=0 && j+1<n && board[i-1][j+1]!='B') ans.add(new Pair(i-1,j+1));

        if(i+1>=0 && i+1<m && j>=0 && j<n && board[i+1][j]!='B') ans.add(new Pair(i+1,j));
        if(i+1>=0 && i+1<m && j-1>=0 && j-1<n && board[i+1][j-1]!='B') ans.add(new Pair(i+1,j-1));
        if(i+1>=0 && i+1<m && j+1>=0 && j+1<n && board[i+1][j+1]!='B') ans.add(new Pair(i+1,j+1));

        if(i>=0 && i<m && j-1>=0 && j-1<n && board[i][j-1]!='B') ans.add(new Pair(i,j-1));
        if(i>=0 && i<m && j+1>=0 && j+1<n && board[i][j+1]!='B') ans.add(new Pair(i,j+1));
        return ans;
    }

    public int adjacentMines(char[][] board,ArrayList<Pair> nodes){
        int count = 0;
        for(Pair p : nodes)
        {
            if(board[p.x][p.y]=='M') count++;
        }
        return count;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        int m = board.length;
        int n = board[0].length;
        if(board[x][y]=='M')
        {
            board[x][y]='X';
            return board;
        }

        Deque<Pair> dq = new ArrayDeque<>();
        Pair p = new Pair(x,y);
        dq.addLast(p);
        board[x][y] = 'B';

        while(!dq.isEmpty())
        {
            Pair curr = dq.removeFirst();
            ArrayList<Pair> nbs = getNeighbours(board,m,n,curr);
            int nbMines = adjacentMines(board,nbs);
            if(nbMines>0)
            {
                board[curr.x][curr.y]=(char)('0'+nbMines);
                continue;
            }
            else
            {
                for(Pair nb : nbs)
                {
                    board[nb.x][nb.y] = 'B';
                    dq.addLast(nb);
                }
            }

        }
        return board;
    }
}