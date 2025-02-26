class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int n = nums.length;
        int negSum = 0, posSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++)
        {
            negSum += nums[i];
            posSum += nums[i];

            maxSum = Math.max(maxSum, Math.max(Math.abs(negSum), posSum));

            if(negSum > 0)
            negSum = 0;

            if(posSum < 0)
            posSum = 0;

        }
        return maxSum;
    }
}