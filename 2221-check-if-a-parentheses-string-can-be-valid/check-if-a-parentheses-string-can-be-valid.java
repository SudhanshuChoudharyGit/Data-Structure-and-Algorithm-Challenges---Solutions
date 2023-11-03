class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        if(n%2!=0) return false;

        int balance = 0;
        int flippable = 0;
        int ind = 0;
        
        while(ind<n)
        {
            char ch = s.charAt(ind);
            if(locked.charAt(ind)=='0') flippable++;
            else if(ch=='(') balance++;
            else if(ch==')') balance--;
            if(balance+flippable<0) return false;
            ind++;
        }
        if(balance>flippable) return false;

        balance = 0;
        flippable = 0;
        ind = n-1;
        while(ind>=0)
        {
            char ch = s.charAt(ind);
            if(locked.charAt(ind)=='0') flippable++;
            else if(ch==')') balance++;
            else if(ch=='(') balance--;
            if(balance+flippable<0) return false;
            ind--;
        }
        if(balance>flippable) return false;

        return true;



    }
}