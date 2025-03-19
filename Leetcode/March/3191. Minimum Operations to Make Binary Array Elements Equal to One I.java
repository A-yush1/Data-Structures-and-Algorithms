class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        int totalFlips = 0, flipsForCurrEle = 0;
        int k = 3;

        boolean isFlipped[] = new boolean[n];

        for(int i=0; i<n; i++)
        {
            if(i >= k && isFlipped[i-k] == true)
            flipsForCurrEle--;

            if((nums[i] == 0 && flipsForCurrEle % 2 == 0) || (nums[i] == 1 && flipsForCurrEle % 2 == 1))
            {
                if(i + k - 1 >= n)
                return -1;

                totalFlips++;
                flipsForCurrEle++;
                isFlipped[i] = true;
            }

        }

        return totalFlips;
    }
}