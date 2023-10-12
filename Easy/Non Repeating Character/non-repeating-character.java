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
        Deque<Character> dq = new ArrayDeque<>();
        char ans = '$';
        for(char c : S.toCharArray())
        {
            freq[c-'a']++;
            if(freq[c-'a']==1) dq.addLast(c);
            while(dq.size()>0 && freq[dq.getFirst()-'a']!=1)
            {
                dq.removeFirst();
            }
            if(dq.size()==0) ans='$';
            else ans = dq.getFirst();
        }
        return ans;
    }
}

