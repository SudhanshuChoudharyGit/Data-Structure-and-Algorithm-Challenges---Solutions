class Pair{
    int start;
    int end;

    Pair(int start,int end){
        this.start=start;
        this.end=end;
    }
}

class CompareHelper implements Comparator<int[]>{
    @Override
    public int compare(int[] p1,int[] p2)
    {
        return p1[0]-p2[0];
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new CompareHelper());
        ArrayList<Pair> arr = new ArrayList<>();
        int n = intervals.length;

        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];

        for(int i=1;i<n;i++)
        {
            if(currEnd >= intervals[i][0]) currEnd = Math.max(currEnd,intervals[i][1]);
            else
            {
                arr.add(new Pair(currStart,currEnd));
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
            }
        }
        arr.add(new Pair(currStart,currEnd));
        int[][] ans = new int[arr.size()][2];
        for(int i=0;i<arr.size();i++)
        {
            ans[i][0] = arr.get(i).start;
            ans[i][1] = arr.get(i).end;
        }

        return ans;
    }
}