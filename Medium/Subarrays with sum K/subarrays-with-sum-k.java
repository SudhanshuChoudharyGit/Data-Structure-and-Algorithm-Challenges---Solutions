//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        int[] prefixsum = new int[N];
        int sum = 0;
        
        for(int i=0;i<N;i++)
        {
            sum+=Arr[i];
            prefixsum[i]=sum;
        }
        
        HashMap<Integer,Integer> freq = new HashMap<>();
        freq.put(0,1);
        int count=0;
        for(int i=0;i<N;i++)
        {
            if(freq.containsKey(prefixsum[i]-k))
            {
                count += freq.get(prefixsum[i]-k);
            }
            freq.put(prefixsum[i],freq.getOrDefault(prefixsum[i],0)+1);
        }
        return count;
    }
}