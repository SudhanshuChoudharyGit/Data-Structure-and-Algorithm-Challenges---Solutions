class Solution {

    //mathematical
    public int gcd(int x,int y){
        if(y==0) return x;
        return gcd(y,x%y);
    }

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }

    //brute force
    /*
    public boolean isDivisor(String str,String s)
    {
        int lenbase = str.length();
        int lenmain = s.length();
        if(lenmain%lenbase!=0) return false;
        int x = lenmain/lenbase;
        StringBuilder sb = new StringBuilder();
        while(x-->0) sb.append(str);
        if(sb.toString().equals(s)) return true;
        return false;
    }

    public String gcdOfStrings(String str1, String str2) {
        boolean even = (str1.length()%2==0)&&(str2.length()%2==0);
        String str = (str1.length()<=str2.length())? str1 : str2;
        while(str.length()>0)
        {
            if(isDivisor(str,str1) && isDivisor(str,str2))
            {
                return str;
            }
            str = str.substring(0,str.length()-1);
        }
        return "";
    }
    */
}