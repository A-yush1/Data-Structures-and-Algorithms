class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        Map<Integer, Integer> mp = new TreeMap<>();

        for(int i=0; i<nums1.length; i++)
        {
            int id = nums1[i][0];
            int val = nums1[i][1];
            mp.put(id, val);
        }

        for(int i=0; i<nums2.length; i++)
        {
            int id = nums2[i][0];
            int val = nums2[i][1];

            if(mp.containsKey(id))
            {
                int currVal = mp.get(id);
                mp.put(id, currVal + val);
            }
            else
            mp.put(id, val);
        }

        int sz = mp.size();

        int res[][] = new int[sz][2];
        int i = 0;
        for(int it:mp.keySet())
        {
            res[i][0] = it;
            res[i][1] = mp.get(it);
            i++;
        }

        return res;

    }
}