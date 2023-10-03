class Solution {

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
}