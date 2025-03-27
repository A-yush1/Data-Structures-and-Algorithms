class Solution {
    public int minimumIndex(List<Integer> nums) {
        
        int n = nums.size();

        int majorityEle = nums.get(0);
        int cnt = 1;

        for(int i=1; i<n; i++)
        {
            if(nums.get(i) == majorityEle)
            cnt++;
            else
            cnt--;

            if(cnt == 0)
            {
                majorityEle = nums.get(i);
                cnt = 1;
            }
        }

        int totalCnt = 0;
        for(int i=0; i<n; i++)
        {
            if(nums.get(i) == majorityEle)
            totalCnt++;
        }

        int currCnt = 0;
        for(int i=0; i<n-1; i++)
        {
            if(nums.get(i) == majorityEle)
            currCnt++;

            int firstPartCnt = currCnt;
            int secondPartCnt = totalCnt - firstPartCnt;

            if(firstPartCnt * 2 > (i + 1) && secondPartCnt * 2 > (n - i - 1))
            return i;
        }

        return -1;
    }
}