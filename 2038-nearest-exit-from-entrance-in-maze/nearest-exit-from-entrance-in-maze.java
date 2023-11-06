class Pair{
    int x;
    int y;

    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {

    public boolean isExit(int x,int y,int m,int n){
        if(x==0 || x==m-1 || y==0 || y==n-1) return true;
        return false;
    }

    public ArrayList<Pair> getNeighbours(int x,int y,boolean[][] vis,char[][] maze,int m,int n){
        //-1,0| 0,-1 | 1,0 |0,1
        ArrayList<Pair> nbs = new ArrayList<>();
        if(x-1>=0 && x-1<m && y>=0 && y<n && vis[x-1][y]==false && maze[x-1][y]=='.') nbs.add(new Pair(x-1,y));
        if(x+1>=0 && x+1<m && y>=0 && y<n && vis[x+1][y]==false && maze[x+1][y]=='.') nbs.add(new Pair(x+1,y));
        if(x>=0 && x<m && y-1>=0 && y-1<n && vis[x][y-1]==false && maze[x][y-1]=='.') nbs.add(new Pair(x,y-1));
        if(x>=0 && x<m && y+1>=0 && y+1<n && vis[x][y+1]==false && maze[x][y+1]=='.') nbs.add(new Pair(x,y+1));
        return nbs;
    }


    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] vis = new boolean[m][n];
        Deque<Pair> dq = new ArrayDeque<>();
        int ex = entrance[0];
        int ey = entrance[1];
        vis[ex][ey] = true;
        dq.addLast(new Pair(ex,ey));
        int steps = 0;
        while(!dq.isEmpty())
        {
            int size = dq.size();
            while(size-- > 0)
            {
                Pair currPos = dq.removeFirst();
                int currX = currPos.x;
                int currY = currPos.y;
                if(!(currX == ex && currY==ey) && isExit(currX,currY,m,n)) return steps;
                for(Pair nb : getNeighbours(currX,currY,vis,maze,m,n))
                {
                    dq.addLast(nb);
                    vis[nb.x][nb.y] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}