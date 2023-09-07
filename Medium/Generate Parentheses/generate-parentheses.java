//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  
    void backtrack(int n,int open,int closed,String str,List<String> ans){
        if(open>n || closed>n || open<closed) return;
        if(open==n && closed==n)
        {
            ans.add(new String(str));
            return;
        }
        backtrack(n,open+1,closed,str+"(",ans);
        backtrack(n,open,closed+1,str+")",ans);
    }
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> ans = new ArrayList<>();
        String str = "";
        backtrack(n,0,0,str,ans);
        return ans;
    }
}