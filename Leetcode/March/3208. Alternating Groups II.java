class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int n = colors.length;
        int itr = 1;
        int i = 1;
        int prevCol = colors[0];
        int currLen = 1;
        int cnt = 0;

        while(itr <= n + k - 2)
        {
            if(i == n)
            i = 0;

            if(colors[i] != prevCol)
            {
              
                currLen++;
                if(currLen >= k)
                cnt++;

            }
            else
            {
                currLen = 1;
            }

            

            prevCol = colors[i];
            i++;
            itr++;
        }

        return cnt;
    }
}