

class Solution {
    final int MOD = 1000000007;

    int findPow(int val, int x) {
        if (x == 0) return 1;

        int currPow = val;
        int res = 1;

        while (x != 0) {
            if ((x & 1) != 0) res = (int) ((1L * res * currPow) % MOD);

            currPow = (int) ((1L * currPow * currPow) % MOD);
            x = (x >> 1);
        }

        return res;
    }

    int[] sieve(int n) {
        int isPrime[] = new int[n + 1];
        Arrays.fill(isPrime, 1);

        isPrime[0] = isPrime[1] = 0;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i] == 1) {  // Yeh check add karna zaroori hai
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }

        return isPrime;
    }

    int[] findPrimeScore(List<Integer> nums) {
        int n = nums.size();
        int mx = -1;
        for (int num : nums) mx = Math.max(num, mx);

        int isPrime[] = sieve(mx);

        int primeScore[] = new int[n];
        int it = 0;

        for (int num : nums) {
            int originalNum = num;  // Save original number

            for (int i = 2; i * i <= num; i++) {
                if (isPrime[i] == 1) {
                    if (num % i != 0) continue;

                    primeScore[it]++;
                    while (num % i == 0) num = num / i;
                }
            }

            // If num > 1, it means it's a prime number itself (like 17, 19, etc.)
            if (num > 1) {
                primeScore[it]++;
            }

            it++;
        }

        return primeScore;
    }

    int[] findNextGreaterToRight(int nums[]) {
        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();

            if (st.isEmpty()) res[i] = n;
            else res[i] = st.peek();

            st.push(i);
        }

        return res;
    }

    int[] findPrevGreaterOrEqualIdxToLeft(int nums[]) {
        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();

            if (st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();

            st.push(i);
        }

        return res;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();

        int primeScore[] = findPrimeScore(nums);
        int nextGreaterIdxToRight[] = findNextGreaterToRight(primeScore);
        int prevGreaterOrEqualIdxToLeft[] = findPrevGreaterOrEqualIdxToLeft(primeScore);

        int noOfTimesTaken[] = new int[n];

        for (int i = 0; i < n; i++) {
            noOfTimesTaken[i] = (i - prevGreaterOrEqualIdxToLeft[i]) * (nextGreaterIdxToRight[i] - i);
        }

        int sorted[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = nums.get(i);
            sorted[i][1] = i;
        }

        Arrays.sort(sorted, (arr1, arr2) -> arr1[0] - arr2[0]);

        int it = 0;
        int res = 1;
        while (k > 0) {
            int val = sorted[it][0];
            int idx = sorted[it][1];
            it++;

            int ops = Math.min(noOfTimesTaken[idx], k);
            k -= ops;

            res = (int) ((1L * res * findPow(val, ops)) % MOD);
        }

        return res;
    }
}
