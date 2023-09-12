class Point{
    public double dis;
    public int x;
    public int y;

    public Point(int x,int y){
        this.dis = (double)Math.sqrt(x*x+y*y);
        this.x = x;
        this.y = y;
    }
}

class MyComparator implements Comparator<Point>{
    @Override
    public int compare(Point a, Point b)
    {
        return Double.compare(b.dis,a.dis);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxheap = new PriorityQueue<>(new MyComparator());
        for(var pt : points)
        {
            if(maxheap.size()<k) maxheap.add(new Point(pt[0],pt[1]));
            else
            {
                if((double)Math.sqrt(pt[0]*pt[0]+pt[1]*pt[1])<maxheap.peek().dis)
                {
                    maxheap.poll();
                    maxheap.add(new Point(pt[0],pt[1]));
                }
            }
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++)
        {
            Point p = maxheap.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }

        return ans;
    }
}