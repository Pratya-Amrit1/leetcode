class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxcost = 0;
        for (int cost : costs) {
            maxcost = Math.max(maxcost, cost);
        }
        int[] freq = new int[maxcost + 1];
        for (int cost : costs) {
            freq[cost]++;
        }
        int ans = 0;
        for (int price = 1; price <= maxcost; price++) {
            if (freq[price] == 0) {
                continue;
            }
            int canbuy = Math.min(freq[price], coins / price);
            ans += canbuy;
            coins -= canbuy * price;

            if (coins < price) {
                break;
            }
        }
        return ans;
    }
}