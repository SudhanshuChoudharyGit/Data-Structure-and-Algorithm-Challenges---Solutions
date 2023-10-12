//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //hashmap of letters -> freq;
        int[] freq = new int[26];
        for(char c : S.toCharArray())
        {
            freq[c-'a']++;
        }
        for(char c : S.toCharArray())
        {
            if(freq[c-'a']==1) return c;
        }
        return '$';
        
        
        
        
        
        
        /*
        HashMap<Character,Integer> freq = new HashMap<>();
        char[] ch = S.toCharArray();
        
        for(char c : ch)
        {
            if(freq.containsKey(c)) freq.put(c,freq.get(c)+1);
            else freq.put(c,1);
        }
        
        for( char c : ch)
        {
            if(freq.get(c)==1) return c;
        }
        
        return '$';*/
    }
}

