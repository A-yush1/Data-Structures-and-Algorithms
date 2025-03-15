class Solution {
    boolean isPossible(int amount, int nums[], int k)
    {
        int houseCnt = 0;
        int i = 0;
        while(i < nums.length)
        {
            if(nums[i] <= amount)
            {
                houseCnt++;
                i += 2;
            }
            else
            i += 1;
            
            if(houseCnt == k)
            return true;
        }

        return false;
    }
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int mn = Integer.MAX_VALUE;
        int mx = -1;

        for(int i=0; i<n; i++)
        {
            mn = Math.min(mn, nums[i]);
            mx = Math.max(mx, nums[i]);
        }

        int res = -1;

        while(mn <= mx)
        {
            int mid = mn + (mx - mn) / 2;

            if(isPossible(mid, nums, k))
            {
                res = mid;
                mx = mid - 1;
            }
            else
            mn = mid + 1;
        }

        return res;
    }
}