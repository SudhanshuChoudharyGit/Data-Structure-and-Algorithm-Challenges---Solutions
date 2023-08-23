//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends



class Solution
{
    public:
    int helper(int W,int wt[],int val[],int n,int currW,int index,vector<vector<int>>& memo) {
        if(memo[currW][index]!=-1) return memo[currW][index];
        if(index==n)
        {
            memo[currW][index]=0;
            return 0;
        }
        
        
        
        if(currW+wt[index] > W) memo[currW][index] = helper(W,wt,val,n,currW,index+1,memo);
        
        else memo[currW][index] = max(helper(W,wt,val,n,currW,index+1,memo),val[index]+helper(W,wt,val,n,currW+wt[index],index+1,memo));
        
        return memo[currW][index];
        
        
    }
    
    
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int n) 
    {
        vector<vector<int>> memo(W+1,vector<int>(n+1,-1));
        return helper(W,wt,val,n,0,0,memo);
    }
};

//{ Driver Code Starts.

int main()
 {
    //taking total testcases
    int t;
    cin>>t;
    while(t--)
    {
        //reading number of elements and weight
        int n, w;
        cin>>n>>w;
        
        int val[n];
        int wt[n];
        
        //inserting the values
        for(int i=0;i<n;i++)
            cin>>val[i];
        
        //inserting the weights
        for(int i=0;i<n;i++)
            cin>>wt[i];
        Solution ob;
        //calling method knapSack()
        cout<<ob.knapSack(w, wt, val, n)<<endl;
        
    }
	return 0;
}
// } Driver Code Ends