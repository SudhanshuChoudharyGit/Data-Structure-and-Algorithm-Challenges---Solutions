//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    void dfs(vector<vector<int>>& adj,vector<bool>& vis,int i,int V) {
        vis[i]=true;
        for(int j=0;j<V;j++)
        {
            if(j!=i && adj[i][j]==1 && !vis[j]) dfs(adj,vis,j,V);
        }
    }
  
    int numProvinces(vector<vector<int>> adj, int V) {
        // code here
        vector<bool> vis(V,false);
        int count=0;
        for(int i=0;i<V;i++)
        {
            if(!vis[i]) 
            {
                dfs(adj,vis,i,V);
                count++;
            }
        }
        return count;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int V,x;
        cin>>V;
        
        vector<vector<int>> adj;
        
        for(int i=0; i<V; i++)
        {
            vector<int> temp;
            for(int j=0; j<V; j++)
            {
                cin>>x;
                temp.push_back(x);
            }
            adj.push_back(temp);
        }
        

        Solution ob;
        cout << ob.numProvinces(adj,V) << endl;
    }
    return 0;
}
// } Driver Code Ends