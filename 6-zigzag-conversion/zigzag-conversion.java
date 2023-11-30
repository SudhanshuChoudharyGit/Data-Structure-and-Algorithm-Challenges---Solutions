class Solution {
    public String convert(String s, int numRows) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;

        StringBuffer[] sbArray = new StringBuffer[numRows];
        for(int i=0;i<numRows;i++) sbArray[i] = new StringBuffer();

        int i = 0;
        while(i<len)
        {
            //vertically down
            for(int ind = 0; ind<numRows && i<len ; ind++) 
            sbArray[ind].append(charArray[i++]);
            //obliquely up
            for(int ind = numRows-2; ind>=1 && i<len ; ind--)
            sbArray[ind].append(charArray[i++]);
        }

        StringBuffer ans = new StringBuffer();
        for(StringBuffer currsb : sbArray) ans.append(currsb);
        return ans.toString();

    }
}