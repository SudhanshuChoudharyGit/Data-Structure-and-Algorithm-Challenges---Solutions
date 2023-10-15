class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes,true);
        int count = 0;
        for(int i=2;i<n;i++)
        {
            if(primes[i]==true)
            {
                count++;
                for(int j=2;i*j<n;j++)
                {
                    primes[i*j] = false;
                }
            }
        }

        return count;
    }
}