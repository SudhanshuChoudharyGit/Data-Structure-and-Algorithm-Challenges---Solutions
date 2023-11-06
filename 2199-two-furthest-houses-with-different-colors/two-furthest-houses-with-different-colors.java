class Solution {
    public int maxDistance(int[] colors) {
       int n = colors.length;
       for(int i=0;i<=n/2;i++)
       {
           if(colors[i]!=colors[n-i-1]) return n-i-1;
           if(i>0 && colors[i]!=colors[i-1]) return n-i-1;
       }
       return 0;
    }
}