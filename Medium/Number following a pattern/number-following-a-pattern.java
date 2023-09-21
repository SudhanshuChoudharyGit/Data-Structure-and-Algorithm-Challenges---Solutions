//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        String ans = "1";
        int ind = 0;
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='D') ans = ans.substring(0,ind)+Integer.toString(i+2)+ans.substring(ind,ans.length());
            else
            {
                ans = ans + Integer.toString(i+2);
                ind = ans.length()-1;
            }
        }
        return ans;
    }
}
