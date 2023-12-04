class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0;

        for(int i=0;i<points.length-1;i++)
        {
            int startX = points[i][0];
            int startY = points[i][1];

            int endX = points[i+1][0];
            int endY = points[i+1][1];

            distance += Math.max(Math.abs(endX-startX),Math.abs(endY-startY));
        }

        return distance;
    }
}