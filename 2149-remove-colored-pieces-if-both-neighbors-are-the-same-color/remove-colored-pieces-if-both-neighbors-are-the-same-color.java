class Solution {
    public boolean winnerOfGame(String colors) {
        int aturns = 0;
        int bturns = 0;
        for(int i=1;i<colors.length()-1;i++)
        {
            if(colors.charAt(i)==colors.charAt(i-1) && colors.charAt(i)==colors.charAt(i+1))
            {
                if(colors.charAt(i)=='A') aturns++;
                else bturns++;
            }
        }
        return (aturns>bturns) ? true : false;
    }
}