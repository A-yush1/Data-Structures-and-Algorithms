class Solution {
    public int countDays(int days, int[][] meetings) {
        
        Arrays.sort(meetings, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));


        int firstEle = meetings[0][0];
        int lastEle = meetings[0][1];

        int meetingDays = 0;

        for(int i=1; i<meetings.length; i++)
        {
            if(lastEle >= meetings[i][0])
            lastEle = Math.max(lastEle, meetings[i][1]);
            else
            {
                meetingDays += (lastEle - firstEle + 1);

                firstEle = meetings[i][0];
                lastEle = meetings[i][1];
            }
        }

        meetingDays += (lastEle - firstEle + 1);

        return days - meetingDays;

    }
}