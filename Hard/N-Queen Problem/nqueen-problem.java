//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static void backtrack(int n,int c,boolean[] rows,boolean[] leftDiag,boolean[] rightDiag,ArrayList<Integer> entry,ArrayList<ArrayList<Integer>> ans) {
        if(c==n)
        {
            ans.add(new ArrayList<>(entry));
            return;
        }
        for(int r=0;r<n;r++)
        {
            if(rows[r] || leftDiag[r+c] || rightDiag[r-c+n]) continue;
            
            entry.add(r+1);
            rows[r] = leftDiag[r+c] = rightDiag[r-c+n] = true;
            backtrack(n,c+1,rows,leftDiag,rightDiag,entry,ans);
            entry.remove(entry.size()-1);
            rows[r] = leftDiag[r+c] = rightDiag[r-c+n] = false;
        }
    }
    
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> entry = new ArrayList<>();
        
        boolean[] rows = new boolean[n];
        boolean[] leftDiag = new boolean[2*n];
        boolean[] rightDiag = new boolean[2*n];
        
        backtrack(n,0,rows,leftDiag,rightDiag,entry,ans);
        
        return ans;
    }
}