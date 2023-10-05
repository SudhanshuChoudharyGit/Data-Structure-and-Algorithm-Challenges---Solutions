class Solution {
    public int minimumLength(String s) {
        int l= 0;
        int r = s.length()-1;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r)) return r-l+1;
            else
            {
                while(l<r && s.charAt(l)==s.charAt(l+1)) l++;
                if(l==r) return 0;
                while(s.charAt(r)==s.charAt(r-1)) r--;
            }
            l++;
            r--;
        }
        return 1;
    }
}