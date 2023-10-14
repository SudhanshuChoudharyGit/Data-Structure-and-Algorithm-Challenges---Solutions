//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Pair{
    int start;
    int end;
    
    public Pair(int start,int end){
        this.start = start;
        this.end = end;
    }
}

class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here
        
        //sort(interval) - start time
        Arrays.sort(Intervals,Comparator.comparingInt(interval -> interval[0]));
        
        int start = Intervals[0][0];
        int end = Intervals[0][1];
        ArrayList<Pair> ans = new ArrayList<>();
        for(int i=1;i<Intervals.length;i++)
        {
            if(Intervals[i][0]<=end) end = Math.max(end,Intervals[i][1]);
            else
            {
                ans.add(new Pair(start,end));
                start = Intervals[i][0];
                end = Intervals[i][1];
            }
        }
        ans.add(new Pair(start,end));
        
        int n = ans.size();
        int[][] mergedIntervals = new int[n][2];
        for(int i=0;i<n;i++)
        {
            mergedIntervals[i][0] = ans.get(i).start;
            mergedIntervals[i][1] = ans.get(i).end;
        }
        return mergedIntervals;
        
        
    }
}