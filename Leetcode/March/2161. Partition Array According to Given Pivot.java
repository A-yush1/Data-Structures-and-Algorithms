class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;
        List<Integer> greaterNumIdx = new ArrayList<>();
        int res[] = new int[n];

        int it = 0;
        int cntEql = 0;
        for(int i=0; i<n; i++)
        {
            if(nums[i] == pivot)
            cntEql++;
            else if(nums[i] < pivot)
            res[it++] = nums[i];
            else if(nums[i] > pivot)
            greaterNumIdx.add(i);
        }

        while(cntEql != 0)
        {
            res[it++] = pivot;
            cntEql--;
        }
        for(int i=0; i<greaterNumIdx.size(); i++)
        res[it++] = nums[greaterNumIdx.get(i)];

        return res;
    }
}