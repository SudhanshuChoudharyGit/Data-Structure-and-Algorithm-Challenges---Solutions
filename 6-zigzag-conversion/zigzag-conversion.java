class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();

        StringBuffer[] sbrArray = new StringBuffer[numRows];
        for(int i=0;i<numRows;i++) sbrArray[i] = new StringBuffer();

        int i = 0;
        while(i<len)
        {
            for(int ind=0;ind<numRows && i<len;ind++)
            sbrArray[ind].append(s.charAt(i++));
            for(int ind=numRows-2;ind>=1 && i<len;ind--)
            sbrArray[ind].append(s.charAt(i++));
        }

        StringBuffer ans = new StringBuffer();
        for(StringBuffer curr : sbrArray) ans.append(curr);

        return ans.toString();
    }
}