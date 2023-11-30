class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        int numCopy = num;
        int i=3;
        while(numCopy>0)
        {
            arr[i--] = numCopy%10;
            numCopy /= 10;
        }
        Arrays.sort(arr);
        int res = (arr[0] + arr[1])*10 + (arr[2]+arr[3]);
        return res;   
    }
}