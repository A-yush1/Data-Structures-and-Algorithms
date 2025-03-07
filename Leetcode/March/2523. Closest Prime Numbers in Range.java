class Solution {

    boolean[] sieve(int right)
    {
       boolean isPrime[] = new boolean[right + 1];
       Arrays.fill(isPrime, true);
       isPrime[0] = isPrime[1] = false;

       for(int num=2; num * num <= right; num++)
       {
            for(int multiple = num * num; multiple <= right; multiple += num)
            isPrime[multiple] = false;
       }

       return isPrime;
 
    }
    public int[] closestPrimes(int left, int right) {
        
        boolean isPrime[] = sieve(right);
        int num1 = -1, num2 = -1;
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1; 
        int minDiff = Integer.MAX_VALUE;
        int cnt = 0;
        for(int num = left; num <= right; num++)
        {
            boolean prime = isPrime[num];
            if(prime && cnt % 2 == 0)
            {
                
                num1 = num;
                cnt++;
            }
            else if(prime && cnt % 2 == 1)
            {
                num2 = num;
                cnt++;
            }

            if(num1 != -1 && num2 != -1 && minDiff > Math.abs(num1 - num2))
            {
                
                minDiff = Math.abs(num1 - num2);
                res[0] = Math.min(num1, num2);
                res[1] = Math.max(num1, num2);
            }

        }

        return res;
    }
}