class Solution {
    boolean isPossible(int arr[][])
    {
        int n = arr.length;
        int first = arr[0][0];
        int last = arr[0][1];

        int cnt = 1;

        for(int i=1; i<n; i++)
        {
            if(last > arr[i][0])
            last = Math.max(last, arr[i][1]);
            else
            {
                cnt++;
                first = arr[i][0];
                last = arr[i][1];

                if(cnt == 3)
                return true;
            }

        }

        return false;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        
        int noOfRect = rectangles.length;
        int x[][] = new int [noOfRect][2];

        for(int i=0; i<noOfRect; i++)
        {
            x[i][0] = rectangles[i][0];
            x[i][1] = rectangles[i][2];
        }

        Arrays.sort(x, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        boolean poss = isPossible(x);

        if(poss == true)
        return true;

        int y[][] = new int[noOfRect][2];

        for(int i=0; i<noOfRect; i++)
        {
            y[i][0] = rectangles[i][1];
            y[i][1] = rectangles[i][3];
        }

        Arrays.sort(y, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        poss = isPossible(y);
        return poss;
    }
}