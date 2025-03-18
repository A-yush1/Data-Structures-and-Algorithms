class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int trackOneMask = 0;
        int res = 1;

        int i = 0, j = 0;

        while(j < n)
        {
            while((trackOneMask & nums[j]) != 0)
            {
                trackOneMask ^= nums[i];
                i++;
            }

            res = Math.max(res, j - i + 1);

            trackOneMask |= nums[j];
            j++;
        }

        return res;
    }
}