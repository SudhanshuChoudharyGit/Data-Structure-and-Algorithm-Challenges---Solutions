class Solution {
    public int minimumSum(int num) {
        int[] numArray = new int[4];
        int numCopy = num;
        int i=3;
        while(numCopy>0)
        {
            numArray[i--] = numCopy%10;
            numCopy /= 10;
        }
        Arrays.sort(numArray);
        int result = (numArray[0] + numArray[1])*10 + (numArray[2]+numArray[3]);
        return result;
    }
}