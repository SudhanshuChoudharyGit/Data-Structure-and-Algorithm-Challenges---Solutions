class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        int len = s.length();
        int spaceInd = 0;
        int spaceCount = spaces.length;
        while(ind<len)
        {
            if(spaceInd<spaceCount && spaces[spaceInd]==ind)
            {
                spaceInd++;
                sb.append(" ");
            }
            sb.append(s.charAt(ind));
            ind++;
        }
        return sb.toString();
    }
}