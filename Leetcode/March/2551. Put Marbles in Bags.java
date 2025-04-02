class Solution {
    public long putMarbles(int[] weights, int k) {
        
        if(k == 1)
        return 0;
        int n = weights.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i=0; i<n-1; i++)
        {
            int val = weights[i] + weights[i+1];

            if(minHeap.size() < k - 1)
            minHeap.add(val);
            else
            {
                if(minHeap.peek() < val)
                {
                    minHeap.poll();
                    minHeap.add(val);
                }
            }

            if(maxHeap.size() < k - 1)
            maxHeap.add(val);
            else
            {
                if(maxHeap.peek() > val)
                {
                    maxHeap.poll();
                    maxHeap.add(val);
                }
            }
        }

        long diff = 0;
        while(!minHeap.isEmpty() && !maxHeap.isEmpty())
        {
            diff += minHeap.poll();
            diff -= maxHeap.poll();
        }

        return diff;
    }
}