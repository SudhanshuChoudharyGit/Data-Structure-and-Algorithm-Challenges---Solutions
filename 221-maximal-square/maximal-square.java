class Pair {
        int first;
        int second;

        Pair(){
            first=0;
            second=0;
        }

        Pair(int x,int y) {
            this.first=x;
            this.second=y;
        }
    };

class Solution {

    

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxside=0;
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]= Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    maxside = Math.max(maxside,dp[i][j]);
                }   
            }
        }
        return maxside*maxside;
    }
}