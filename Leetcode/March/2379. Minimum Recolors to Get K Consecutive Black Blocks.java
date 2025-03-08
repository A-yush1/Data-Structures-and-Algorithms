class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();

        int whiteCnt = 0;
        int minRecolors = n;
        for(int i=0; i<n; i++)
        {
            if(i <= k - 1)
            {
                if(blocks.charAt(i) == 'W')
                whiteCnt++;

            }
            else
            {
                minRecolors = Math.min(minRecolors, whiteCnt);
                if(blocks.charAt(i - k) == 'W')
                whiteCnt--;
                if(blocks.charAt(i) == 'W')
                whiteCnt++;
            }
        }

        minRecolors = Math.min(minRecolors, whiteCnt);

        return minRecolors;
    }
}