class Solution {
public:

    int f(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=pow(n%10,2);
            n/=10;
        }
        return sum;
    }

    bool isHappy(int n) {
        int slow = n;
        int fast = f(n);
        while(slow!=fast)
        {
            slow=f(slow);
            fast=f(f(fast));
        }
        return slow==1;
    }
};