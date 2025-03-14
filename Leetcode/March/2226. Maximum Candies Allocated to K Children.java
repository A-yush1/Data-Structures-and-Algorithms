class Solution {
    boolean isPossible(int candies[], long k, int candiesToBeGiven)
    {
        long child = 0;
        for(int i=0; i<candies.length; i++)
        {
            if(candies[i] >= candiesToBeGiven)
            child += candies[i] / candiesToBeGiven;

            if(child >= k)
            return true;
        }

        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        
        int n = candies.length;

        int start = 1;
        int end = -1;

        for(int i=0; i<n; i++)
        end = Math.max(end, candies[i]);
        int res = 0;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(isPossible(candies, k, mid))
            {
                res = mid;
                start = mid + 1;
            }
            else
            end = mid - 1;
        }

        return res;
    }
}