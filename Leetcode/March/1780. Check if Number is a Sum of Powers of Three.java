class Solution {
    public boolean checkPowersOfThree(int n) {
        
        int powVal = 1;
        while(powVal < n)
        {
            powVal *= 3;
        }

        while(n != 0 && powVal != 0)
        {
            if(powVal <= n)
            {
                n -= powVal;
               
               
            }
            powVal /= 3;
        }

        return (n == 0);
    }
}