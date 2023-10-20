//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public int subsetSum(int[] arr,int n,int target)
    {
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i=0;i<=n;i++) dp[i][0] = true;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                if(arr[i-1]<=j) dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        int minSum = 0; 
        for(int j=target/2;j>=0;j--) 
        {
            if(dp[n][j]==true)
            {
                minSum = j;
                break;
            }
        }
        return minSum;
    }

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int totalSum = 0;
	    for(int x : arr) totalSum += x;
	    int minSum = subsetSum(arr, n,totalSum);
	    return Math.abs(totalSum-2*minSum);
	} 
}
