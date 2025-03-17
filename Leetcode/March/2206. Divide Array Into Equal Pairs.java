class Solution {
    public boolean divideArray(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);

        int cnt = 1;

        for(int i=1; i<n; i++)
        {
            if(nums[i] != nums[i-1])
            {
                if(cnt % 2 != 0)
                return false;

                cnt = 1;

            }
            else
            cnt++;


        }

        if(cnt % 2 != 0)
        return false;
        else
        return true;
    }
}