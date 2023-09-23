class Solution {
    public boolean isSubsequence(String s, String t) {
        int l=0;
        int r=0;
        int lens = s.length();
        int lent = t.length();
        while(l<lens && r<lent)
        {
          if(s.charAt(l)==t.charAt(r)) l++;
          r++;
        }
        return l==lens;
    }
}