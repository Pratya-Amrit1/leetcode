class Solution {
    
    public boolean canPartition(int[] arr) {
        //space optimization
        int n = arr.length;
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true; 

        if (arr[0] <= target)
            prev[arr[0]] = true;
        for (int i = 1; i < n; i++) {
            
            boolean[] cur = new boolean[target + 1];
            cur[0] = true;

            for (int sum = 1; sum <= target; sum++) {
                boolean notTaken = prev[sum];
                boolean taken = false;
                if (arr[i] <= sum)
                    taken = prev[sum - arr[i]];

                cur[sum] = notTaken || taken;
            }
            prev = cur;
        }
        return prev[target];
    }
    }
