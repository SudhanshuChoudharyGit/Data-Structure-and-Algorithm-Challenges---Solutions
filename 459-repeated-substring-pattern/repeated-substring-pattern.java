class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int currlen=len/2;currlen>=1;currlen--)
        {
            if(len%currlen==0)
            {
                String currSubstring = s.substring(0,currlen);
                StringBuffer sb = new StringBuffer();
                for(int j=0;j<len/currlen;j++)
                {
                    sb.append(currSubstring);
                }
                if(sb.toString().equals(s)) return true;
            }
        }

        return false;
    }
}