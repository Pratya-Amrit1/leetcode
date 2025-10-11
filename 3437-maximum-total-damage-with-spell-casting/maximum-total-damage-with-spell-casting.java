import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int p : power)
            count.put(p, count.getOrDefault(p, 0) + 1);

        List<int[]> vals = new ArrayList<>();
        vals.add(new int[]{-1000000000, 0});
        for (var e : count.entrySet())
            vals.add(new int[]{e.getKey(), e.getValue()});

        int n = vals.size();
        long[] dp = new long[n];
        long best = 0;
        int j = 1;

        for (int i = 1; i < n; i++) {
            // slide j forward if too close
            while (j < i && vals.get(j)[0] < vals.get(i)[0] - 2)
                best = Math.max(best, dp[j++]);

            dp[i] = best + 1L * vals.get(i)[0] * vals.get(i)[1];
        }

        long ans = 0;
        for (long x : dp) ans = Math.max(ans, x);
        return ans;
    }
}