class Solution {
    public String getHint(String secret, String guess) {
        //first solution
        int n = secret.length();
        int[] freq = new int[10];
        int[] guesstracker = new int[n];
        int bulls = 0;
        int cows = 0;
        for(int i=0;i<n;i++)
        {
            freq[secret.charAt(i)-'0']++;
        }

        for(int i=0;i<n;i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
            {
                bulls++;
                freq[secret.charAt(i)-'0']--;
                guesstracker[i]=1;
            }
        }

        for(int i=0;i<n;i++)
        {

            if(guesstracker[i]==0 && freq[guess.charAt(i)-'0']>0)
            {
                cows++;
                freq[guess.charAt(i)-'0']--;
            }
        }
        String ans = Integer.toString(bulls)+"A"+Integer.toString(cows)+"B";
        return ans;
    }
}