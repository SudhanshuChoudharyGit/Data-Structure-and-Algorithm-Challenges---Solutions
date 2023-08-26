//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node merge(Node head,Node mid)
    {
        Node temp= new Node(0);
        Node ptr = temp;
        Node temp1 = head;
        Node temp2 = mid;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data<=temp2.data)
            {
                ptr.next=temp1;
                temp1=temp1.next;
            }
            else
            {
                ptr.next=temp2;
                temp2=temp2.next;
            }
            ptr=ptr.next;
        }
        while(temp1!=null)
            {
                ptr.next=temp1;
                temp1=temp1.next;
                ptr=ptr.next;
            }
        while(temp2!=null)
            {
                ptr.next=temp2;
                temp2=temp2.next;
                ptr=ptr.next;
            }
            
        head = temp.next;
        temp.next=null;
        return head;
    }
    
    
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head.next==null) return head;
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid = slow.next;
        slow.next=null;
        head=mergeSort(head);
        mid=mergeSort(mid);
        head=merge(head,mid);
        return head;
    }
}


