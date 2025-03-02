class Solution {
    public int[] applyOperations(int[] nums) {
        
        int n = nums.length;
        int ops = n-1;
        for(int i=0; i<ops; i++)
        {
            if(nums[i] == nums[i+1])
            {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }

        int i = 0;
        for(int j=0; j<n; j++)
        {
            if(nums[j] != 0)
            {
                if(i != j)
                {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }

                i++;
            } 
        }

        return nums;

    }
}