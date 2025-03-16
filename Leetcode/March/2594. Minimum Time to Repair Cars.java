class Solution {
    boolean isPossible(long t, int ranks[], int cars)
    {
        int carsCnt = 0;
        for(int r : ranks)
        {
            carsCnt += Math.sqrt(t / r);
            if(carsCnt >= cars)
            return true;
        }

        return false;

    }
    public long repairCars(int[] ranks, int cars) {
        
        int n = ranks.length;
        long start = 1;
        
        int mn = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        mn = Math.min(mn, ranks[i]);

        long end = 1L * mn * cars * cars;

        long res = -1;
        while(start <= end)
        {
            long mid = start + (end - start) / 2;

            if(isPossible(mid, ranks, cars))
            {
                res = mid;
                end = mid - 1;
            }
            else
            start = mid + 1;
        } 

        return res;
        
    }
}