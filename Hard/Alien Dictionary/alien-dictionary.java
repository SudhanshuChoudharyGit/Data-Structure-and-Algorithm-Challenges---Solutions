//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<Integer>[] adjList = new ArrayList[K];
        
        for (int i = 0; i < K; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<N-1;i++)
        {
            char[] ch1 = dict[i].toCharArray();
            char[] ch2 = dict[i+1].toCharArray();
            int x = 0;
            int y= 0;
            while(x<ch1.length && y<ch2.length)
            {
                char c1 = ch1[x++];
                char c2 = ch2[y++];
                if(c1!=c2)
                {
                    adjList[c1-'a'].add(c2-'a');
                    break;
                }
            }
        }

        
        
        
        int[] incomingEdges = new int[K];
        for(List<Integer> l : adjList)
        {
            for(int x : l) incomingEdges[x]++;
        }


        
        Deque<Integer> q = new ArrayDeque<Integer>();
        for(int i=0;i<K;i++)
        {
            if(incomingEdges[i]==0) q.addLast(i);
        }
        
        String ans = "";
        
        while(q.size()>0)
        {
            int node = q.getFirst();
            ans += (char)('a'+node);
            q.removeFirst();
            for(int x : adjList[node])
            {
                incomingEdges[x]--;
                if(incomingEdges[x]==0) q.addLast(x);
            }
        }
        
        
        return ans;
        
    }
}