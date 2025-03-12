class Solution {
    public int maximumCount(int[] nums) {
        
        int n = nums.length;
        int posCnt = 0;
        int negCnt = 0;

        for(int i=0; i<n; i++)
        {
            if(nums[i] > 0)
            posCnt++;
            else if(nums[i] < 0)
            negCnt++;
        }

        return Math.max(posCnt, negCnt);
        

    }
}