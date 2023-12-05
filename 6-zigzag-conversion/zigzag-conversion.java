class Solution {
    public String convert(String s, int numRows) {
    int n = s.length();
    StringBuffer[] array = new StringBuffer[numRows];
    for(int i=0;i<numRows;i++) array[i] = new StringBuffer();

    int i=0;
    while(i<n)
    {
        //vertically downward
        for(int ind=0;ind<numRows && i<n;ind++)
        {
            array[ind].append(s.charAt(i++));
        }

        //bent upward
        for(int ind=numRows-2;ind>=1 && i<n;ind--)
        {
            array[ind].append(s.charAt(i++));
        }
    }

    StringBuffer ans = new StringBuffer();
    for(StringBuffer curr : array) ans.append(curr);

    return ans.toString();

    }
}