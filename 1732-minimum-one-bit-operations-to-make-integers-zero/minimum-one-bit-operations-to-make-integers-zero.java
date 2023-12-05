class Solution {
    public int minimumOneBitOperations(int n) {
        //setbit check
        // (1<<i)&n
        // f(x)


        int[] bits = new int[32]; //bits -> f(x) = 2*f(x-1) + 1;
        bits[0] = 1;

        for(int i=1;i<32;i++)
        {
            bits[i] = 2*bits[i-1] + 1;
        }

        int count = 0;
        int flag = 0;
        for(int i=31;i>=0;i--)
        {
            if(((1<<i)&n )!=0)
            {
                flag++;
                if(flag%2!=0)
                {
                    count+=bits[i];
                }
                else count-=bits[i];
            }
        }
        return count;
    }
}