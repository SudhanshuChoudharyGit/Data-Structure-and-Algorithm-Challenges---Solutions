//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;
#define RANGE 255


// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    string countSort(string arr){
        // code here
        int a[26]={0};
        int n=arr.length();
        
        for(char c : arr)
        {
            a[c-'a']++;
        }
        
        for(int i=1;i<26;i++)
        {
            a[i]=a[i-1]+a[i];
        }
        
        char char_array[n];
        for(int i=0;i<n;i++)
        {
            char_array[a[arr[i]-'a']-1]=arr[i];
            a[arr[i]-'a']--;
        }
        
        string ans;
        for(char c : char_array)
        {
            ans+=c;
        }
        
        return ans;
    }
};


//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        string arr;
        cin>>arr;
        Solution obj;
        cout<<obj.countSort(arr)<<endl;
    }
    return 0;
}

// } Driver Code Ends