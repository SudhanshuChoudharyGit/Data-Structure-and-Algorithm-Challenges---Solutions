//{ Driver Code Starts
#include<bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution{

    // Function to find the trapped water between the blocks.
    public:
    long long trappingWater(int arr[], int n){
        // code here
        //using 2 pointers
        int l=0;
        int r=n-1;
        long long maxL=0;
        long long maxR=0;
        long long ans=0;
        while(l<=r)
        {
            if(maxL<=maxR)
            {
                ans+=max((long long)0,maxL-arr[l]);
                maxL=max(maxL,(long long)arr[l]);
                l++;
            }
            else
            {
                ans+=max((long long)0,maxR-arr[r]);
                maxR=max(maxR,(long long)arr[r]);
                r--;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        
        int a[n];
        
        //adding elements to the array
        for(int i =0;i<n;i++){
            cin >> a[i];            
        }
        Solution obj;
        //calling trappingWater() function
        cout << obj.trappingWater(a, n) << endl;
        
    }
    
    return 0;
}
// } Driver Code Ends