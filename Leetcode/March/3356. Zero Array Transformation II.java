class Solution {
    boolean check(int k, int nums[], int queries[][])
    {
        int n = nums.length;
        int diffArr[] = new int[n];

        for(int i=0; i<=k; i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];

            diffArr[l] += x;
            if(r + 1 < n)
            diffArr[r + 1] -= x;
        }

        int cummSum = 0;

        for(int i=0; i<n; i++)
        {
            cummSum += diffArr[i];

            if(nums[i] - cummSum > 0)
            return false;

        }

        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int q = queries.length;

        boolean flag = true;
        for(int i=0; i<n; i++)
        {
            if(nums[i] != 0)
            {
                flag = false;
                break;
            }
        }
        if(flag == true)
        return 0;

        int start = 0, end = q - 1;
        int res = -1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(check(mid, nums, queries) == true)
            {
                res = mid + 1;
                end = mid  - 1;
            }
            else
            start = mid + 1;
        }

        return res;
    }
}